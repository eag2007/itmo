; Вариант 51081
; Программа осуществляет асинхронный вывод данных на ВУ-1
; Программа начинается с адреса 2AF16. Размещаемая строка находится по адресу 58416.
; Строка должна быть представлена в кодировке КОИ-8.
; Формат представления строки в памяти: АДР1: СИМВ1 СИМВ2 АДР2: СИМВ3 СИМВ4 ... СТОП_СИМВ.
; Ввод или вывод строки должен быть завершен по символу c кодом 00 (NUL). 
; Стоп символ является обычным символом строки и подчиняется тем же правилам расположения 
; в памяти что и другие символы строки.


ORG 0x2AF
MODE:       WORD 0x0
TMP:        WORD 0x0
INDEX:      WORD 0x584

START:
    JUMP MAIN_LOOP

MAIN_LOOP:
    IN 3
    AND #0x40
    BEQ MAIN_LOOP
    CALL CHECK_MODE

CHECK_MODE:
    LD MODE
    BEQ IF_MODE_0
    JUMP IF_MODE_1
    RET

IF_MODE_0:
    INC
    ST MODE
    LD (INDEX)
    SWAB
    CALL OUTPUT_SYMBOL
    JUMP MAIN_LOOP

IF_MODE_1:
    CLA
    ST MODE
    LD (INDEX)+
    CALL OUTPUT_SYMBOL
    JUMP MAIN_LOOP

OUTPUT_SYMBOL:
    OUT 2   
    CALL CHECK_SYMBOL
    RET

CHECK_SYMBOL:
    CMP #0x00
    BEQ HALT
    RET

HALT:
    HLT

ORG 0x584
MESSAGE:    WORD 0xD1E2, 0xE4CE, 0xCDD1, 0x3600