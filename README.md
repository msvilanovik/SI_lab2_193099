# SI_lab2_193099

Втора лабораториска вежба по Софтверско инженерство

Моника Свилановиќ, 193099

Control Flow Graph

![CFG](https://user-images.githubusercontent.com/81697823/120245169-a37bfb00-c26c-11eb-8641-4b5b21a0ee7b.png)


Цикломатска комплексност
-Цикломатската комплексност на овој код е 8, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=7, па цикломатската комплексност изнесува 8.
Истата комплексност се добива и според формулата E-V+2, каде Е е бројот на ребра, а V е бројот на јазли. Во случајов E е 27, а V е 21, па се добива 27-21+2=8.

Тест случаи според критериумот Multiple condition
-За овој критериум ги земав сите if услови кои имаат 2 или 3 проверки и според операциите && и || ги напишав комбинациите соодветно. Со помош на Lazy evaluation не беа потребни сите можни комбинации.
![multiple_condition](https://user-images.githubusercontent.com/81697823/120245182-b5f63480-c26c-11eb-9320-cceaad2a63fa.png)

Тест случаи според критериумот Every branch
-За овој критериум беше потребно да се напишат тест случаи кои ќе ја поминат секоја гранка. Во графот има вкупно 27 гранки, а за нивно изминување ми беа потребни 7 тест случаи кои ќе ги поминат сите услови и гранења.
![every_branch](https://user-images.githubusercontent.com/81697823/120245197-c9090480-c26c-11eb-8c05-7995f54cb580.png)

