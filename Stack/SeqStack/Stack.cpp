#include <iostream>
#include "Stack.h"
/**
 * @FlieName SequenceList
 * @Description: TODO ˳��ջ����ʵ��
 * @Author ��˪
 * @Date 2019/10/4
 * @Version V1.0
 **/
using namespace std;
void InitStack(SeqStack s)
{
	s->top = 0;
}

bool StackEmpty(SeqStack s)
{
	if (s->top == 0)
	{
		return true;
	}

	return false;
}

//��ջ
bool PushStack(SeqStack s, ElementType value)
{
	if (s->top == MAXSIZE)
	{
		return false;
	}

	s->stack[s->top] = value;
	s->top++;
	return true;
}

//��ջ
ElementType PopStack(SeqStack s)
{
	if (s->top == 0)
	{
		return false;
	}


	s->top--;
	return s->stack[s->top];
}

//��ӡԪ��
void PrintStack(SeqStack s) 
{
	if (s->top==0)
	{
		return;
	}

	for (int i = s->top-1; i >= 0; i--)
	{
		cout << s->stack[i] << endl;
	}
	return;
}

//��ó���
int StackLength(SeqStack s)
{
	return s->top;
}


//���ջ
void StackClear(SeqStack s)
{
	s->top = 0;
}