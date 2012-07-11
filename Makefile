all: monopoly

monopoly:
	gcc monopoly.c -lncurses -o monopoly -std=c99
