
# TODO

Необходимо разработать CRUD backend сервис "online аудиотека".
Сервис состоит из Rest приложения и базы данных.
Сервис хранит следующую информацию:
1. Мелодия (название, год, продолжительность, композитор, жанры, исполнители)
2. Композитор
3. Исполнители
4. Жанры
   Сервис должен выполнять следующие функции:
5. Добавление мелодии
6. Редактирование мелодии
7. Получение полного списка мелодий
8. Поиск мелодий по названию и/или исполнителю и/или жанру и/или композитору
9. Получение полного списка исполнителей
10. Получение полного списка композиторов
    Приложение должно быть разработано с использованием Spring Boot, в качестве базы можно использовать Postgres 

## Implementation

* GET /api/compositors - Список всех композиторов
* GET /api/compositors/{id} - Получение композиторы по id
* POST /api/compositors - добавить композитора. Body: CreateCompositorRequest
* PUT /api/compositors - обновить композитора. Body: UpdateCompositorRequest


* GET /api/musicians - Список всех исполнителей
* GET /api/musicians/{id} - Получение исполнителя по id
* POST /api/musicians - добавить исполнителя. Body: CreateMusicianRequest
* PUT /api/musicians - обновить исполнителя. Body: UpdateMusicianRequest


* GET /api/melodies - Список всех мелодий
* GET /api/melodies/{id} - Получение мелодии по id
* POST /api/melodies - добавить мелодию. Body: CreateMelodyRequest
* PUT /api/melodies - обновить мелодию. Body: UpdateMelodyRequest
* POST /api/melodies - Поиск мелодий по названию и/или исполнителю и/или жанру и/или композитору. Body: SearchMelodyRequest
