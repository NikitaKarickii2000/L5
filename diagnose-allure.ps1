# Диагностика и настройка Allure

Write-Host "=== Диагностика проблем с Allure ===" -ForegroundColor Cyan

# Проверяем текущую директорию
Write-Host "Текущая директория: $PWD" -ForegroundColor Yellow

# Проверяем существование директории target
if (Test-Path "target") {
    Write-Host "✓ Директория target существует" -ForegroundColor Green
} else {
    Write-Host "✗ Директория target не существует - тесты не запускались" -ForegroundColor Red
}

# Проверяем существование директории target/allure-results
if (Test-Path "target\allure-results") {
    Write-Host "✓ Директория target\allure-results существует" -ForegroundColor Green
    
    # Проверяем наличие файлов в директории
    $files = Get-ChildItem "target\allure-results" -File
    if ($files.Count -gt 0) {
        Write-Host "✓ В директории есть файлы ($($files.Count) шт.)" -ForegroundColor Green
    } else {
        Write-Host "✗ Директория target\allure-results пуста" -ForegroundColor Red
    }
} else {
    Write-Host "✗ Директория target\allure-results не существует" -ForegroundColor Red
    Write-Host "Создаем директорию..." -ForegroundColor Yellow
    New-Item -ItemType Directory -Path "target\allure-results" -Force | Out-Null
}

# Проверяем файл pom.xml
if (Test-Path "pom.xml") {
    Write-Host "✓ Файл pom.xml существует" -ForegroundColor Green
    
    $pomContent = Get-Content -Path "pom.xml" -Raw
    
    if ($pomContent -match "allure-junit5") {
        Write-Host "✓ Зависимость allure-junit5 найдена в pom.xml" -ForegroundColor Green
    } else {
        Write-Host "✗ Зависимость allure-junit5 не найдена в pom.xml" -ForegroundColor Red
    }
    
    if ($pomContent -match "allure-maven") {
        Write-Host "✓ Плагин allure-maven найден в pom.xml" -ForegroundColor Green
    } else {
        Write-Host "✗ Плагин allure-maven не найден в pom.xml" -ForegroundColor Red
    }
} else {
    Write-Host "✗ Файл pom.xml не найден" -ForegroundColor Red
}

# Проверяем наличие тестового класса с аннотациями Allure
$sampleTestPath = "src\test\java\SimpleAllureTest.java"
if (Test-Path $sampleTestPath) {
    Write-Host "✓ Тестовый класс SimpleAllureTest.java существует" -ForegroundColor Green
    
    $testContent = Get-Content -Path $sampleTestPath -Raw
    if ($testContent -match "io.qameta.allure") {
        Write-Host "✓ Импорты аннотаций Allure найдены в тестовом классе" -ForegroundColor Green
    } else {
        Write-Host "✗ Импорты аннотаций Allure не найдены в тестовом классе" -ForegroundColor Red
    }
} else {
    Write-Host "✗ Тестовый класс SimpleAllureTest.java не найден" -ForegroundColor Red
}

Write-Host "`n=== Рекомендуемые действия ===" -ForegroundColor Cyan

# Определяем путь к Maven
$mavenPath = $null
$ideaMavenPath = "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.5\plugins\maven\lib\maven3\bin\mvn.cmd"
if (Test-Path $ideaMavenPath) {
    $mavenPath = $ideaMavenPath
    Write-Host "Найден Maven в IntelliJ IDEA" -ForegroundColor Green
} else {
    # Проверяем, доступен ли Maven в PATH
    try {
        $mvnVersion = & mvn --version 2>&1
        if ($LASTEXITCODE -eq 0) {
            $mavenPath = "mvn"
            Write-Host "Maven доступен через команду mvn" -ForegroundColor Green
        }
    } catch {
        Write-Host "Maven не найден в PATH" -ForegroundColor Yellow
    }
}

if ($mavenPath) {
    Write-Host "`n1. Запустить тесты с генерацией отчета Allure:"
    if ($mavenPath -eq "mvn") {
        Write-Host "   mvn clean test" -ForegroundColor Yellow
    } else {
        Write-Host "   & '$mavenPath' clean test" -ForegroundColor Yellow
    }
    
    Write-Host "`n2. Проверить создание директории с результатами:"
    Write-Host "   Test-Path target\allure-results" -ForegroundColor Yellow
    
    Write-Host "`n3. Запустить отчет Allure:"
    Write-Host "   allure serve target\allure-results" -ForegroundColor Yellow
} else {
    Write-Host "`nMaven не найден. Запустите тесты через IntelliJ IDEA:" -ForegroundColor Yellow
    Write-Host "1. Найдите класс SimpleAllureTest.java" -ForegroundColor Yellow
    Write-Host "2. Щелкните правой кнопкой мыши и выберите 'Run SimpleAllureTest'" -ForegroundColor Yellow
    Write-Host "3. После запуска проверьте создание директории target\allure-results" -ForegroundColor Yellow
}

# Создаем тестовый файл результатов, если директория пуста
if (!(Test-Path "target\allure-results\*")) {
    Write-Host "`nДиректория результатов пуста или не существует. Создаем тестовый файл результата..." -ForegroundColor Yellow
    
    # Создаем директорию, если она не существует
    if (!(Test-Path "target\allure-results")) {
        New-Item -ItemType Directory -Path "target\allure-results" -Force | Out-Null
    }
    
    # Создаем тестовый файл результатов
    $testResultContent = @"
{
  "uuid": "12345678-1234-1234-1234-123456789012",
  "historyId": "test-history-id",
  "name": "Тестовый результат для проверки Allure",
  "status": "passed",
  "stage": "finished",
  "start": 1681554000000,
  "stop": 1681554001000
}
"@
    
    $testResultContent | Out-File -FilePath "target\allure-results\test-result.json" -Encoding utf8
    
    Write-Host "Тестовый файл результатов создан. Проверьте отчет Allure:" -ForegroundColor Green
    Write-Host "allure serve target\allure-results" -ForegroundColor Yellow
}

Write-Host "`nДиагностика завершена." -ForegroundColor Cyan