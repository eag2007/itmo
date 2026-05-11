; Основная программа должна увеличивать на 2 содержимое X (ячейки памяти с адресом 04116) в цикле.
; Обработчик прерывания должен по нажатию кнопки готовности ВУ-3 осуществлять вывод результата 
; вычисления функции F(X)=5X-3 на данное ВУ, a по нажатию кнопки готовности ВУ-2 записать содержимое РД данного
; ВУ в Х
; Если Х оказывается вне ОДЗ при выполнении любой операции по его изменению, то необходимо 
; в Х записать минимальное по ОДЗ число.

; -125 <= 5x <= 130
; -25 <= x <= 26

ORG 0x0
V0:     WORD    $DEFAULT, 0x180
V1:     WORD    $DEFAULT, 0x180
V2:     WORD    $VECTOR_2, 0x180
V3:     WORD    $VECTOR_3, 0x180
V4:     WORD    $DEFAULT, 0x180
V5:     WORD    $DEFAULT, 0x180
V6:     WORD    $DEFAULT, 0x180
V7:     WORD    $DEFAULT, 0x180
V8:     WORD    $DEFAULT, 0x180

ORG 0x10
X:      WORD    0
MIN_X:  WORD    -25
MAX_X:  WORD    26

START:
    DI
    CLA
    OUT 0x1
    OUT 0x3
    OUT 0xB
    OUT 0xF
    OUT 0x13
    OUT 0x17
    OUT 0x1C
    OUT 0x1F
    ; разрешить прерывание и вектор 2 1000 | 0010
    ; разрешить прерывание и вектор 3
    LD #0xA
    OUT 5
    LD #0xB
    OUT 7      
    EI

MAIN:
    DI
    LD X
    INC
    INC
    CALL CHECK
    ST X
    EI
    JUMP MAIN

CHECK:
    CMP MAX_X
    BPL IF_MAX
    CMP MIN_X
    BMI IF_MIN
    RET

IF_MAX:
    LD MIN_X
    RET

IF_MIN:
    LD MIN_X
    RET

DEFAULT:
    IRET

VECTOR_2:
    DI
    IN 4
    ST X
    EI
    IRET

VECTOR_3:
    DI
    LD X
    NOP
    ASL
    ASL
    ADD X
    SUB #3
    NOP
    OUT 6
    EI
    IRET

HALT:
    HLT

    
