# Лабораторна робота 3 — Навігація в Jetpack Compose

## Тема: Голосування / Рейтинг (Варіант 4)

Багатоекранний Android-застосунок «Голосування» з навігацією між екранами та передачею параметрів.

## Функціональність

- Додавання варіантів для голосування
- Голосування за варіанти (лічильник голосів)
- Автоматичне сортування за кількістю голосів
- Відображення поточного лідера у заголовку
- Видалення варіантів

## Екрани

### 1. VoteListScreen
- Список всіх варіантів відсортованих за голосами
- Лідер виділяється 🏆
- Кнопка + для додавання нового варіанту
- Натискання на елемент відкриває деталі

### 2. AddVoteScreen
- Форма додавання нового варіанту
- Поле назви (обов'язкове) та опису (необов'язкове)
- Кнопки «Додати» та «Скасувати»

### 3. VoteDetailsScreen
- Детальна інформація про варіант
- Кількість голосів
- Кнопка 👍 Проголосувати
- Кнопка видалення варіанту

<img width="376" height="771" alt="image" src="https://github.com/user-attachments/assets/21f4ca7e-b0ff-4f4d-88d3-da14529b915d" />
<img width="370" height="777" alt="image" src="https://github.com/user-attachments/assets/397ca072-0abe-4e3f-abaa-4de02c853085" />
<img width="370" height="776" alt="image" src="https://github.com/user-attachments/assets/e17f3ed5-b0fc-4fbd-8b1d-62f6376625a8" />
<img width="374" height="776" alt="image" src="https://github.com/user-attachments/assets/837e5b74-0e1a-4f8c-8075-aa082508f0fd" />
<img width="368" height="774" alt="image" src="https://github.com/user-attachments/assets/a0778709-3126-4d5c-8be1-35d7891c1987" />


## Структура проєкту

```
com.example.votingapp/
├── MainActivity.kt
├── model/
│   └── VoteOption.kt
├── navigation/
│   ├── AppRoutes.kt
│   └── AppNavigation.kt
├── viewmodel/
│   └── VoteViewModel.kt
└── ui/
    ├── screens/
    │   ├── VoteListScreen.kt
    │   ├── AddVoteScreen.kt
    │   └── VoteDetailsScreen.kt
    └── theme/
        └── Theme.kt
```

## Технології

- Kotlin
- Jetpack Compose
- Navigation Compose
- ViewModel + StateFlow (MVI)
- Material3
