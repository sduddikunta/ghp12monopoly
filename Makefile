all: monopoly

monopoly: monopoly.c
	gcc monopoly.c -lncurses -o monopoly -std=c99

clean:
	rm -rf *.o monopoly
