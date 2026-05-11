; ДАННЫЙ ВАРИАНТ НЕ ЯВЛЯЕТСЯ МОИМ И БЫЛ ВЫПОЛНЕН ИСКЛЮЧИТЕЛЬНО 
; В УЧЕБНЫХ ЦЕЛЯХ, ДЛЯ ЛУЧШЕГО ПОНИМАНИЯ МАТЕРИАЛА

; ВАРИАНТ 10825

; Вариант выполнен на языке ассемблера БЭВМ

ORG 0x1F3

START:                          ; очистка аккумулятора, начало программы
        CLA
        LD ADDRESS_FIRST_ELEMENT
        ST TMP
        JUMP MAIN_LOOP

MAIN_LOOP:                      ; цикл состояния
        CLA
        IN 5
        AND #0x40
        BEQ MAIN_LOOP
        CALL CHECK_MODE

READ_SYMBOL:                    ; чтение символа
        IN 4
        CALL CHECK_SYMBOL
        RET

CHECK_SYMBOL:                   ; проверка символа
        ST ELEMENT_TMP
        AND #0x00FF
        CMP #0x0000
        BEQ HALT
        LD ELEMENT_TMP
        RET

CHECK_MODE:                     ; проверка режима
        LD MODE
        BEQ IF_MODE_0
        JUMP IF_MODE_1
        RET

IF_MODE_0:                      ; обработка режима если MODE==0
        INC
        ST MODE
        LD (TMP)
        SWAB
        CALL READ_SYMBOL
        SWAB
        ST (TMP)+
        JUMP MAIN_LOOP

IF_MODE_1:                      ; обработка режима если MODE==1
        CLA
        ST MODE
        LD (TMP)
        CALL READ_SYMBOL
        ST (TMP)
        JUMP MAIN_LOOP

HALT:   
        ST (TMP)
        HLT

ELEMENT_TMP: WORD ?
ADDRESS_FIRST_ELEMENT: WORD 0x59D ; адрес первого элемента массива
TMP:                   WORD ?     ; текущий указатель на массив
MODE:                  WORD 1     ; режим
