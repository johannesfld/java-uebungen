# build script fuer java-uebungen
# benoetigt nur java (javac + jar)

$SRC = "src"
$OUT = "out"
$JAR = "uebungen.jar"
$MAIN = "uebung.Main"

if (Test-Path $OUT) { Remove-Item -Recurse -Force $OUT }
New-Item -ItemType Directory -Path $OUT | Out-Null

$sources = Get-ChildItem -Path $SRC -Recurse -Filter "*.java" | ForEach-Object { $_.FullName }
[System.IO.File]::WriteAllLines("$PWD\sources.txt", $sources)

Write-Host "Kompiliere $($sources.Count) Dateien..."
javac -encoding UTF-8 -d $OUT "@sources.txt"

if ($LASTEXITCODE -ne 0) {
    Write-Host "Kompilierung fehlgeschlagen." -ForegroundColor Red
    Remove-Item "sources.txt" -ErrorAction SilentlyContinue
    exit 1
}

Write-Host "Erstelle $JAR..."
jar cfe $JAR $MAIN -C $OUT .

Remove-Item "sources.txt"

Write-Host "Fertig. Starten mit: java -jar $JAR" -ForegroundColor Green
