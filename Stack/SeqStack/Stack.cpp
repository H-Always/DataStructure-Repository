#include <iostream>
#include "Stack.h"
/**
 * @FlieName SequenceList
 * @Description: TODO 顺序栈方法实现
 * @Author 余霜
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

//入栈
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

//弹栈
ElementType PopStack(SeqStack s)
{
	if (s->top == 0)
	{
		return false;
	}


	s->top--;
	return s->stack[s->top];
}

//打印元素
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

//获得长度
int StackLength(SeqStack s)
{
	return s->top;
}


//清空栈
void StackClear(SeqStack s)
{
	s->top = 0;
}
