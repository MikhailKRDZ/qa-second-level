"# qa-second-level" 
Java:
Java Error & Exceptions task:
В университете есть несколько факультетов, в которых учатся студенты, объединенные в
группы. У каждого студента есть несколько учебных предметов по которым он получает
оценки. Необходимо реализовать иерархию студентов, групп и факультетов.
• Посчитать средний балл по конкретному предмету в конкретной группе и на
конкретном факультете
• Посчитать средний балл по всем предметам студента
• Посчитать средний балл по предмету для всего университета
Реализовать следующие исключения:
• Оценка ниже 0 или выше 10
• Отсутствие предметов у студента (должен быть хотя бы один)
• Отсутствие групп на факультете
• Отсутствие факультетов в университете
• Отсутствие студентов в группе

Java iofundamental  task:
Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies". Записать в текстовый файл структуру папок и файлов в виде,
 похожем на выполнение программы tree /F. Пример:
Amon Amarth
    |-----2004 - Fate Of Norns
    |       01 - An Ancient Sign Of Coming Storm.mp3
    |       02 - Where Death Seems To Dwell.mp3
    |       03 - The Fate Of Norns.mp3
    |       04 - The Pursuit Of Vikings.mp3
    |       05 - Valkyries Ride.mp3
    |       06 - The Beheading Of A King.mp3
    |       07 - Arson.mp3
    |       08 - Once Sealed In Blood.mp3
    |
    |-----2016 - Jomsviking
    |       01 First Kill.mp3
    |       02 Wanderer.mp3
    |       03 On A Sea Of Blood.mp3
    |       04 One Against All.mp3
    |       05 Raise Your Horns.mp3
    |       06 The Way Of Vikings.mp3
    |       07 At Dawn’s First Light.mp3
    |       08 One Thousand Burning Arrows.mp3
    |       09 Vengeance Is My Name.mp3
    |       10 A Dream That Cannot Be (feat. Doro Pesch).mp3
    |       11 Back On Northern Shores.mp3
    |       12 Death In Fire 2016.mp3
    |       13 Death In Fire (Live).mp3
    |
    |-----2019 - Berserker
            01 Fafner's Gold.mp3
            02 Crack the Sky.mp3
            03 Mjölner, Hammer of Thor.mp3
            04 Shield Wall.mp3
            05 Valkyria.mp3
            06 Raven's Flight.mp3
            07 Ironside.mp3
            08 The Berserker at Stamford Bridge.mp3
            09 When Once Again We Can Set Our Sails.mp3
            10 Skoll and Hati.mp3
            11 Wings of Eagles.mp3
            12 Into the Dark.mp3
Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:
Количество папок
Количество файлов
Среднее количество файлов в папке
Среднюю длинну названия файла

Java. Threads 
Main Task
Разработать консольное многопоточное приложение.
Использовать возможности, предоставляемые пакетом java.util.concurrent.
Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у причала, разгружаться или выполнять оба действия.

