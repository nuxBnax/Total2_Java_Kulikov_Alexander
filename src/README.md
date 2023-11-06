Программа позволяет добавить Игрушку, прописывая ее "Вес" и "Название" (в массиве id проставляется автоматически, 
что гарантирует уникальность игрушки).

Метод summaryRate() суммирует все "Веса" игрушек тем самым определяя в каком диапазоне чисел будет происходить розыгрыш.

Метод generate() генерирует множество из уникальных чисел, которые будут относиться с конкретной игрушке учитывая их "Вес".

Метод writer() записывает результаты совпадений случайного числа с id игрушки. Если файла не существует, то он будет создан,
если он существует, то данные будут в него добавлены.

Метод get() осуществляет сравнение сгенерированного случайного числа с id игрушки и вызывает метод writer().

Метод put() позволяет ввести данные об игрушке, выводит информацию в консоль о том какие данные об игрушках в итоге были
введены и какова теоретическая вероятность выпадения игрушки при розыгрыше.

Метод main() запускает метод put(), проводит минимальную проверку на наличие введенных данных, и запускает метод get() 
такое количество раз какое указано в times (в нашем случае равном 10).

Для удобства заполнения массивов данными создан класс Toy, который также позволяет вывести данные об игрушке.

Примечание! Учитывая маленькую выборку розыгрыша (10 раз) данные выводимые в файл toyRaffle.txt могут не соответствовать
статистике. По-хорошему выборка должна быть близка к 10 000 или 100 000 раз (или выше), тогда полученные результаты будут
блики к расчетным. 