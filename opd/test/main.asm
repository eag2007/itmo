; Найти минимальное 25-разрядное число в массиве стоящее на индексах кратных 4


ORG 0x20
MINIMUM_LEFT:   WORD    0x00FF
MINIMUM_RIGHT:  WORD    0xFFFF

ORG 0x30
MASSIVE:    
    ; Число 1 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 2 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 3 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 4 (обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 5 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 6 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 7 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 8 (обрабатывается)
    WORD 0x0100       ; отрицательное -5
    WORD 0x0005      ; -5
    
    ; Число 9 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 10 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 11 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 12 (обрабатывается)
    WORD 0x0000
    WORD 0x0032      ; 50
    
    ; Число 13 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 14 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 15 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 16 (обрабатывается)
    WORD 0x0100       ; отрицательное -3
    WORD 0x0003      ; -3
    
    ; Число 17 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 18 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 19 (не обрабатывается)
    WORD 0x0000
    WORD 0x0064      ; 100
    
    ; Число 20 (обрабатывается)
    WORD 0x0000
    WORD 0x001E      ; 30

ADDRESS_TMP:    WORD    0x30
LEN_MASSIVE:    WORD    40
COUNT:          WORD    0
LEFT:           WORD    ?
RIGHT:          WORD    ?
MASK_OR:        WORD    0xFF00
MASK_AND:       WORD    0x0100

ORG 0x80
MAIN:
    CALL IF_LEN_MASSIVE_0
    LD LEN_MASSIVE
    DEC
    DEC
    ST LEN_MASSIVE
    LD (ADDRESS_TMP)+
    ST LEFT
    LD (ADDRESS_TMP)+
    ST RIGHT
    LD COUNT
    INC
    ST COUNT
    CALL IF_COUNT_4
    JUMP MAIN

IF_COUNT_4:
    LD #4
    CMP COUNT
    BEQ PROCESS
    RET

PROCESS:
    CLA
    ST COUNT
    LD MASK_AND
    AND LEFT
    BEQ IS_POSITIVE
    JUMP IS_NEGATIVE

IS_POSITIVE:
    JUMP SRAVNENIE

IS_NEGATIVE:
    LD LEFT
    OR MASK_OR
    ST LEFT
    JUMP SRAVNENIE

SRAVNENIE:
    LD LEFT
    CMP $MINIMUM_LEFT
    BEQ EQUALS_LEFT
    BLT TMP_SMALL_LEFT
    RET

TMP_SMALL_LEFT:
    LD LEFT
    ST $MINIMUM_LEFT
    LD RIGHT
    ST $MINIMUM_RIGHT
    RET

EQUALS_LEFT:
    LD RIGHT
    CMP $MINIMUM_RIGHT
    BLT TMP_SMALL_RIGHT
    RET

TMP_SMALL_RIGHT:
    LD LEFT
    ST $MINIMUM_LEFT
    LD RIGHT
    ST $MINIMUM_RIGHT
    RET

IF_LEN_MASSIVE_0:
    LD LEN_MASSIVE
    BEQ HALT
    RET

HALT:
    HLT