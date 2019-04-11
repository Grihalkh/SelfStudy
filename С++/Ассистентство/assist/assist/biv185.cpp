#include "pch.h"

#include <stdio.h>
#include <iostream>

#define WORD_NUM 64
#define WORD_LEN 32

FILE * getFile()
{
	printf("Введите имя файла\n");
	char fileName[64];
	FILE *f;

	gets_s(fileName);
	f = fopen(fileName, "r");

	while (f == NULL)
	{
		printf("Такого файла не существует. Введите другое имя файла\n");
		gets_s(fileName);
		f = fopen(fileName, "r");
	}

	return f;
}

int getWordsFromFile(FILE* file, char arr[][WORD_LEN])
{
	int i = 0;
	while (fscanf(file, "%s", arr[i]) != EOF)
	{
		i++;
	}
	return i;
}

FILE * newFile()
{
	printf("Введите имя для нового файла\n");
	char fileName[64];
	gets_s(fileName);

	FILE *f = fopen(fileName, "w");

	return f;

}

void saveWords(FILE *f, char arr[][WORD_LEN], int wordCount)
{
	for (int i = 0; i < wordCount; i++)
	{
		if (strlen(arr[i]) % 2 == 0)
		{
			fprintf(f, "%s\n", arr[i]);
		}
	}
}

int main()
{
	setlocale(LC_ALL, "rus");

	FILE *f = getFile();

	char arr[WORD_NUM][WORD_LEN];
	int wordCount = getWordsFromFile(f, arr);

	fclose(f);

	f = newFile();

	saveWords(f, arr, wordCount);

	fclose(f);

	return 0;
}
