Консольное приложение

1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/ваш-пользователь/ваш-репозиторий.git
   cd ваш-репозиторий
   ```

2. Соберите проект с помощью Maven:
   ```bash
   mvn clean package
    ```
   Maven создаст JAR-файл в директории target:
   RCS1-1.0-SNAPSHOT.jar — -файл с вашим приложением.

3. Запустите его командой
   ```bash
   java -jar target/RCS1-1.0-SNAPSHOT.jar

   ```
