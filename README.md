Как запустить:
1) Создаем Java проект (File -> New -> Project... -> Java (Next) -> (Next) -> Называем проект "TextFileSortProject" -> Finish
2) Клонируем с гитхаба мой готовый проект в папку только что созданного проекта git clone https://github.com/NeBugAFicha/textToSortProject.git
3) Удаляем папку пустую директорию "src" из нового проекта и переносим все содержимое загруженной директории "textToSortProject" в корневую директорию "TextFileSortProject"
4) Подключаем две зависимости hamcrest-core-1.3.jar и junit.jar (File -> Project Structure... -> Project Settings -> Libraries :-> New Project Library -> Java: 
   1) New Project Library -> Java -> hamcrest-core-1.3.jar -> Open -> Choose Modules (TextFileSortProject) -> OK
   2) New Project Library -> Java -> junit.jar -> Open -> Choose Modules (TextFileSortProject) -> OK
   3) Apply -> OK
__________________________________________________________________________________________________________________    
public static File textFileGenerator(int linesCount, int lineSize) throws IOException : 
 1) Генерируется 3 текстовых файла (testToSort,textToSortBuffer1,textToBuffer2), исходный и два буферных файла
 2) В диапазоне таблицы кодировки ASCII (48-122) заполняется строка размером lineSize случайными символами и затем строка добавляется в два файла textToSort и textToSortBuffer1
 
В главном методе main происходит цепочка действий:
 1) С консоли считывается два параметра: кол-во строк(linesCount), размер строк (lineSize), с диапазоном допустимых значений
 2) 1 раз открывается исходный файл (textToSort) для записи со стиранием всего содержимого, textToSortBuffer1 содержит все что было в textToSort
 3) toggler - булевая переменная переключатель для смены ролей чтения и записи между файлами textToSortBuffer1 и textToSortBuffer2
 4) В первом while цикле происходит поиск минимальной строки с помощью 2 переменных minStr, compareStr, в текущем файле чтения и значение присваивается в minStr
 5) Dо стором цикле происходит повторное считывания с файла чтения для поиска всех совпадений с minStr и последующая запись в файл textToSort, а в случае несовпадения - строка записывается в файл записи
 6) В конце toggler сменяет булевое значение на противоположное для смены ролей чтения и записи
 7) Выход из "бесконечного" цикла while(true) происходит за счет условия отсутствия стартового значения для minStr
 8) Закрытие файла записи textToSort;
Конец