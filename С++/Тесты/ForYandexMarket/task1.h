#pragma once

#include <iostream>
#include <string>
namespace task1 {

#define LEN 128

	char* f(char* string, char c)
	{
		int n = strlen(string);
		for (int i = 0; i < n; i++)
			if (string[i] == c)
			{
				for (int j = i; j < n; j++)
					string[j] = string[j + 1];
				n--;
			}
		return string;
	}

	int main()
	{
		setlocale(LC_ALL, "rus");
		printf("Введите строку\n");
		char string[LEN];
		while (gets_s(string) == 0);

		printf("Введите символ\n");
		char c = getchar();

		printf(f(string, c));

		return 0;
	}




}
