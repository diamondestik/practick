# 2022 зимняя JAVA-практика

## Задания

В репозитории пока один модуль - sidecar - выкачанный со страницы https://start.spring.io/ пустой каркас приложения

### Для начала:
- Добавить себя в контрибьюторы - пришлите мне свои username либо киньте запрос
- Установить необходимые тулы: IDE на свой вкус, JDK 11 +, maven 3.6+
- Выкачать проект, импортировать в IDE, собрать, запустить

### Архитектура приложения
В итоге должно получиться три запускаемых приложения:
- Заглушка, которая принимает GET-запрос с параметром - путем к файлу на локальной файловой системе и отдает его в ответе
- Отдельное приложение, которое периодически ходит к заглушке и получая контент файлов сохраняет их в другую директорию
- Отдельное приложение, которое по событию поднимает определенный файл из директории второго приложения и пытается распарсить его как json