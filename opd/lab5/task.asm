; Доп задание

; Что надо сделать
; 1. отчет в полном объеме
; 2. написать программу, которая, вводит с ВУ-3 команды в 16-коде, сначала старшую часть,
; потом младшую, например, 4022.
; После того, как введена команда HLT (0100) (КАК ПОЯВИЛОСЬ 00),
; управление передается первой введенной команде, которая выполняется.


ORG 0x100
MODE:       WORD    0x000
INDEX:      WORD    ?
COMMAND:    WORD    ?
ADDRESS:    WORD    0x303
TMP:        WORD    ?
HLT_VALUE:  WORD    0x0100

START:
    CLA
    LD ADDRESS
    ST TMP
    JUMP MAIN_LOOP

MAIN_LOOP:
    CLA
    IN 7
    AND #0x40
    BEQ MAIN_LOOP
    JUMP CHECK_MODE

CHECK_MODE:
    LD MODE
    BEQ IF_MODE_0
    JUMP IF_MODE_1
    RET

IF_MODE_0:
    INC
    ST MODE
    LD (TMP)
    CALL READ_SYMBOL
    ST (TMP)
    JUMP MAIN_LOOP

IF_MODE_1:
    CLA
    ST MODE
    LD (TMP)
    SWAB
    CALL READ_SYMBOL
    ST (TMP)+
    SUB HLT_VALUE
    BEQ HLT_MODE
    JUMP MAIN_LOOP

READ_SYMBOL:
    IN 6
    RET

HLT_MODE:
    JUMP (ADDRESS)


; 0200
; AF04
; 4F04
; E308
; 0100

; 0200
; AFFF
; 2F00
; E308
; 0100