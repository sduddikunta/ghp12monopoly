#include <ncurses.h>
#include <string.h>
#include <locale.h>
#include <stdio.h>
#include <stdlib.h>

void simulate(int money, int num_games, int num_houses)
{
	clear();
	curs_set(0);
	char mesg[] = "GHP Mathematics Majors 2012";
	int indent = 2;
	int row, col;
	attron(A_BOLD);
	getmaxyx(stdscr,row,col);
	mvprintw(0,(col-strlen(mesg))/2,"%s", mesg);
	char mesg2[] = "Siddu Duddikunta and Raj Patel";
	mvprintw(1,(col-strlen(mesg2))/2,"%s", mesg2);
	char mesg3[] = "Monopoly Simulation Version 1.2";
	mvprintw(2,(col-strlen(mesg3))/2,"%s", mesg3);
	attroff(A_BOLD);
	init_pair(10, COLOR_WHITE, COLOR_BLACK);
	mvprintw(5, indent, "Simulation");
	mvhline(6, indent, ACS_HLINE, 10);
	mvprintw(7, indent, "Status: Running [");
	init_pair(11, COLOR_YELLOW, COLOR_BLACK);
	attron(COLOR_PAIR(11));
	mvprintw(7, indent + strlen("Status: Running ["), "    1 10000");
	attron(COLOR_PAIR(10));
	mvprintw(7, indent + strlen("Status: Running [    1"), "/");
	mvprintw(7, indent + strlen("Status: Running [    1/10000"), "]");
	mvprintw(8, indent, "[");
	attron(COLOR_PAIR(10));
	mvprintw(8, indent+71, "]");
	attron(COLOR_PAIR(11));
	mvprintw(8, indent+72, " 100%%");
	attron(COLOR_PAIR(10));
	mvprintw(10, indent, "Results");
	mvhline(11, indent, ACS_HLINE, 7);
	init_pair(1, COLOR_MAGENTA, COLOR_BLACK);
	attron(COLOR_PAIR(1));
	mvprintw(12, indent, "Purple: ");
	attroff(COLOR_PAIR(1));
	init_pair(2, COLOR_CYAN, COLOR_BLACK);
	attron(COLOR_PAIR(2));
	mvprintw(13, indent, "Light Blue: ");
	attroff(COLOR_PAIR(2));
	attron(COLOR_PAIR(1));
	mvprintw(14, indent, "Pink: ");
	attroff(COLOR_PAIR(1));
	init_pair(3, COLOR_YELLOW, COLOR_BLACK);
	attron(COLOR_PAIR(3));
	mvprintw(15, indent, "Orange: ");
	attroff(COLOR_PAIR(3));
	init_pair(4, COLOR_RED, COLOR_BLACK);
	attron(COLOR_PAIR(4));
	mvprintw(16, indent, "Red: ");
	attroff(COLOR_PAIR(4));
	attron(COLOR_PAIR(3));
	mvprintw(17, indent, "Yellow: ");
	attroff(COLOR_PAIR(3));
	init_pair(5, COLOR_GREEN, COLOR_BLACK);
	attron(COLOR_PAIR(5));
	mvprintw(18, indent, "Green: ");
	attroff(COLOR_PAIR(5));
	init_pair(6, COLOR_BLUE, COLOR_BLACK);
	attron(COLOR_PAIR(6));
	mvprintw(19, indent, "Dark Blue: ");
	attroff(COLOR_PAIR(6));
	init_pair(7, COLOR_WHITE, COLOR_BLACK);
	attron(COLOR_PAIR(7));	
	refresh();
	int counter = 0;
	int total = num_games;
	int percents[8];
	int results[8];
	for (int i = 0; i < 8; i++)
	{
		percents[i] = 0;
		results[i] = 0;
	}
	FILE *fp;
	char str[100];
	snprintf(str, 100, "%s %d %d %d", "java -jar Monopoly.jar", num_games, money, num_houses);
	fp = popen(str, "r");
	if (fp == NULL) {
		printf("Failed to run command\n" );
		endwin();
		exit(0);
  	}
	char result[2];
	while (counter < total)
	{
		counter++;
		attron(COLOR_PAIR(3));
		mvprintw(7, indent + strlen("Status: Running ["), "                              ");
		mvprintw(7, indent + strlen("Status: Running ["), "%d", counter);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", total);
		attron(COLOR_PAIR(7));
		printw("]");
		fgets(result, 2, fp);
		results[result[0] - '0']++;
		for (int i = 0; i < 8; i++) {
			percents[i] = (results[i]*100)/counter;
		}
		attron(COLOR_PAIR(3));
		mvhline(8, indent+1, '=', (counter*70)/total);
		mvprintw(8, 75, "    ");
		mvprintw(8, 75, "%d%%", (counter*100)/total);
		mvprintw(12, 10, "                              ");
		mvprintw(12, 10, "%d%%", percents[0]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[0]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		attron(COLOR_PAIR(3));
		mvprintw(13, 14, "                              ");
		mvprintw(13, 14, "%d%%", percents[1]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[1]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		attron(COLOR_PAIR(3));
		mvprintw(14, 8, "                              ");
		mvprintw(14, 8, "%d%%", percents[2]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[2]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		attron(COLOR_PAIR(3));
		mvprintw(15, 10, "                              ");
		mvprintw(15, 10, "%d%%", percents[3]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[3]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		attron(COLOR_PAIR(3));
		mvprintw(16, 7, "                              ");
		mvprintw(16, 7, "%d%%", percents[4]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[4]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		attron(COLOR_PAIR(3));
		mvprintw(17, 10, "                              ");
		mvprintw(17, 10, "%d%%", percents[5]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[5]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		attron(COLOR_PAIR(3));
		mvprintw(18, 9, "                              ");
		mvprintw(18, 9, "%d%%", percents[6]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[6]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		attron(COLOR_PAIR(3));
		mvprintw(19, 13, "                              ");
		mvprintw(19, 13, "%d%%", percents[7]);
		attron(COLOR_PAIR(7));
		printw(" [");
		attron(COLOR_PAIR(3));
		printw("%d", results[7]);
		attron(COLOR_PAIR(7));
		printw("/");
		attron(COLOR_PAIR(3));
		printw("%d", counter);
		attron(COLOR_PAIR(7));
		printw("]");
		refresh();
	}
	char mesg4[] = "Press any key to exit";
	mvprintw(22, (col-strlen(mesg4))/2, mesg4);
	getch();
}

void mainScreen()
{
	curs_set(1);
	char mesg[] = "GHP Mathematics Majors 2012";
	int indent = 2;
	int row, col;
	int num_games = 100;
	int num_houses = 0;
	int num_money = 5000;
	attron(A_BOLD);
	getmaxyx(stdscr,row,col);
	mvprintw(0,(col-strlen(mesg))/2,"%s", mesg);
	char mesg2[] = "Siddu Duddikunta and Raj Patel";
	mvprintw(1,(col-strlen(mesg2))/2,"%s", mesg2);
	char mesg3[] = "Monopoly Simulation Version 1.2";
	mvprintw(2,(col-strlen(mesg3))/2,"%s", mesg3);
	attroff(A_BOLD);
	mvprintw(5, indent, "Main Menu");
	mvhline(6, indent, ACS_HLINE, 9);
	mvprintw(7, indent, "1. Begin Simulation");
	mvprintw(8, indent, "2. Number of Games [");
	init_pair(20, COLOR_YELLOW, COLOR_BLACK);
	init_pair(21, COLOR_WHITE, COLOR_BLACK);
	attron(COLOR_PAIR(20));
	printw("%d", num_games);
	attron(COLOR_PAIR(21));
	printw("]");
	mvprintw(9, indent, "3. Number of Houses [");
	attron(COLOR_PAIR(20));
	printw("%d", num_houses);
	attron(COLOR_PAIR(21));
	printw("]");
	mvprintw(10, indent, "4. Starting Money [");
	attron(COLOR_PAIR(20));
	printw("%d", num_money);
	attron(COLOR_PAIR(21));
	printw("]");
	mvprintw(11, indent, "5. Exit");
	mvprintw(13, indent, "Select Option: ");
	refresh();			/* Print it on to the real screen */
	while (1) {
		int n;
		n = getch();
		while (n > 53 || n < 49)
		{
			mvprintw(13, indent + 15, "[Invalid, Try Again]");
			refresh();
			sleep(1);
			mvprintw(13, indent + 15, "                                   ");
			mvprintw(13, indent + 15, "");
			refresh();
			n = getch();
		}
		switch (n)
		{
		case 49:
			simulate(num_money, num_games, num_houses);
			return;
		case 50:
			mvprintw(13, indent, "                ");
			mvprintw(13, indent, "Key New Value: ");
			refresh();
			while (1)
			{
				n = 0;
				scanw("%d", &n);				
				if (n > 0)
				{
					num_games = n;
					break;
				}
				mvprintw(13, indent+15, "[Invalid, Try again]");
				refresh();
				sleep(1);
				mvprintw(13, indent, "                                   ");
				mvprintw(13, indent, "Key New Value: ");
				refresh();
			}
			mvprintw(8, indent, "                               ");
			mvprintw(8, indent, "2. Number of Games [");
			attron(COLOR_PAIR(20));
			printw("%d", num_games);
			attron(COLOR_PAIR(21));
			printw("]");
			mvprintw(13, indent, "                                              ");
			mvprintw(13, indent, "Select Option: ");
			refresh();
			break;
		case 51:
			mvprintw(13, indent, "                ");
			mvprintw(13, indent, "Key New Value: ");
			refresh();
			while (1)
			{
				n = 0;
				scanw("%d", &n);
				if (n >=0 && n <=5)
				{
					num_houses = n;
					break;
				}
				mvprintw(13, indent+15, "[Invalid, Try again]");
				refresh();
				sleep(1);
				mvprintw(13, indent, "                                   ");
				mvprintw(13, indent, "Key New Value: ");
				refresh();
			}
			mvprintw(9, indent, "                               ");
			mvprintw(9, indent, "3. Number of Houses [");
			attron(COLOR_PAIR(20));
			printw("%d", num_houses);
			attron(COLOR_PAIR(21));
			printw("]");
			mvprintw(13, indent, "                                              ");
			mvprintw(13, indent, "Select Option: ");
			refresh();
			break;
		case 52:
			mvprintw(13, indent, "                ");
			mvprintw(13, indent, "Key New Value: ");
			refresh();
			while (1)
			{
				n = 0;
				scanw("%d", &n);
				if (n > 0)
				{
					num_money = n;
					break;
				}
				mvprintw(13, indent + 15, "[Invalid, Try again]");
				refresh();
				sleep(1);
				mvprintw(13, indent, "                                   ");
				mvprintw(13, indent, "Key New Value: ");
				refresh();
			}
			mvprintw(10, indent, "                               ");
			mvprintw(10, indent, "4. Starting Money [");
			attron(COLOR_PAIR(20));
			printw("%d", num_money);
			attron(COLOR_PAIR(21));
			printw("]");
			mvprintw(13, indent, "                                              ");
			mvprintw(13, indent, "Select Option: ");
			refresh();
			break;
		case 53:
			endwin();
			exit(0);
		}
	}
}

int main()
{
	char* locale = setlocale(LC_ALL, "");
	initscr();			/* Start curses mode 		  */
	start_color();
	mainScreen();
	endwin();			/* End curses mode		  */
	return 0;
}
