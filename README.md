Добавляем тесты и разворачиваем простейший CI/CD

Задание состоит из двух частей. Каждая часть оценивается максимум в 5 баллов. Общий максимальный балл за задание: 5 + 5 = 10 баллов

Часть №1 Тестирование (стоит 5 баллов из 10)
Задание
Реализуйте на Java простейшую программу, которая будет считывать из файла числа, а далее отдельными функциями искать среди этих чисел минимальное число, максимальное число, считать их общую сумму и произведение.

Функции должны называться, соответственно _min (минимальное число), _max (максимальное число), _sum (сумма всех чисел), _mult (произведение всех чисел).

Числа в файле записаны в одной строке, друг от друга отделены пробелами. В файле есть минимум одно число. Максимально возможное количество чисел в файле - 1 млн.

Для этой программы подготовьте тесты:

проверяющие корректность работы функций поиска минимума и максимума
проверяющие корректность работы функций сложения и умножения
проверяющие скорость работы программы при увеличении размера входного файла (при увеличении количества чисел в файле).
Пример работы
В файле: 1 4 2 3

Минимальное: 1

Максимальное: 4

Сумма: 10 (1+2+3+4)

Произведение: 24 (1*2*3*4)

Критерии оценки
1 балл: реализуйте функции чтения из файла, поиска минимального числа, поиска максимального числа, сложения и умножения всех чисел из файла
1 балл: реализуйте тесты для проверки корректности функций поиска минимума, максимума, сложения и умножения
1 балл: реализуйте тесты для проверки скорости работы программы при увеличении размера входного файла (для каждой из функций: поиск минимума, максимума, сложение и умножение)
1 балл: реализуйте любой другой тест на ваше усмотрение
1 балл: постройте график зависимости времени выполнения от кол-ва чисел в файле (вы можете измерять время выполнения любой функции из реализованных на ваш выбор)
Часть №2 (стоит 5 баллов из 10)
Github Actions

Travis CI

Circle CI

Задание
Теперь вам необходимо настроить CI-систему для своего мини-проекта.

Критерии оценки
1 балл: заведите репозиторий для своего проекта на GitHub. Оформите простейший README.md (туториал по markdown (файлы формата .md)). Загрузите в репозиторий файлы своего мини-проекта (код, тесты, README.md).
1 балл: подключите к вашему проекту любую CI-систему (выше есть подсказки с вариантами систем, но мы крайне рекомендуем использовать GitHub Actions в рамках этого задания, только если Ваш семинарист не демонстрировал вам другую систему). Обеспечьте возможность запуска тестов в ручном режиме (например, по щелчку кнопки в веб-интерфейсе CI-системы)
1 балл: настройте CI таким образом, чтобы прогон тестов запускался автоматически при любом новом коммите в репозиторий вашего проекта
1 балл: сделайте интеграцию CI-системы и вашего репозитория на GitHub: сделайте бэйдж в README.md, который будет показывать текущий статус тестов. Для информации смотрите тут, тут или в аналогичном доке для выбранной вами CI-системы. Как выглядят бэйджи в целом, можно посмотреть в любом проекте на GitHub, где они сделаны, например, в репозитории Telegram
1 балл: сделайте любую интеграцию CI-системы и какого-либо мессенджера (например, telegram, slack, msteams и т.п.). Настройте систему так, чтобы при успешном прохождении теста посылалось сообщение "все ок", при неуспешном - посылалась информация, какие именно тесты не пройдены. Обратите внимание, тут не нужно писать код, тут нужно взять готовые аддоны / расширения и просто настроить

**Тестирование:**

**1. Чтение файла и работа с функциями**

Все функции работают одинаково: каждая функция получает путь к файлу в качестве аргумента (в репозитории есть конкретные ссылки (в классе для unit- и нагрузочного тестирования). Там передаются ссылки на файлы тестов, которые хранятся в папке samples. Там же находятся результаты всех тестов и информация о входных данных (samples/res.txt) и информация о времени выполнения тестов с 4 по 10 (samples/teststimeresult.txt)

**2. Тестирование функций**

Unit-тесты находятся в файле src/test/java/operations/operationsTest.java. Чтобы избежать переполнения типа при умножении чисел, тесты проводились только для файлов с количеством чисел не более 10. Тестирование можно запустить как непосредственно из файла, так и через интерфейс github actions (см. инструкцию ниже)

**3. Нагрузочное тестирование**

Тестирование проводилось для функции _min. Класс тестирования находится в src/main/java/Benchmarks.java. Тесты были последовательно запущены для файлов /samples/test{4-10}.txt, среднее время работы отображено в samples/teststimeresult.txt

**4. Собственное тестирование**

Было проведено сценарное тестирование для сценария: вычисление оптимума для массива (среднее между максимумом и минимумом). За это тестирование отвечает метод _optimum в классе тестирования src/test/java/operationsTest.java. Подсчет оптимума был реализован для тестов с 1 по 3.

**5. График**

График был построен с использованием библиотеки matplotlib языка python. Используя результаты пункта 3, в файле time_graph.png отображена зависимость. Как и ожидалось, график представляет собой прямую.

**6. Интеграция CI**

В качестве системы CI были выбраны github actions. Реализована возможность ручного запуска тестов для выбранного коммита. Для этого:

- Перейдите на вкладку actions
- Выберите интересующий коммит и кликните на него
- В левой части экрана появится список jobs, где можно увидеть сборку
- Наведите курсор на сборку, появится значок
- Нажмите на значок, затем на re-run jobs
- Сборка будет перезапущена и тесты запущены
- Для просмотра лога сборки кликните на сборку (находится в списке jobs)

**7. Настройка CI**

Реализована возможность автоматического запуска сборки и тестов при каждом новом коммите и pull request. Чтобы увидеть статус после нового коммита или pull request, нужно:

- Нажать на флажок рядом с именем владельца репозитория и последним коммитом
- Для быстрого понимания статуса, можно ориентироваться по значкам:
  - Синяя галочка - сборка прошла успешно, все тесты пройдены
  - Желтый кружок - тестирование в процессе
  - Красный крестик - ошибка при сборке
