#pragma once
/**
 * @FlieName SequenceList
 * @Description: TODO 顺序栈结构
 * @Author 余霜
 * @Date 2019/10/4
 * @Version V1.0
 **/
#define MAXSIZE 1024
using ElementType = int;

typedef struct Stack
{
	ElementType stack[MAXSIZE];
	int top; 		//指针域
}*SeqStack;


//初始化
void InitStack(SeqStack s);

//判断是否为空
bool StackEmpty(SeqStack s);

//压栈
bool PushStack(SeqStack s, ElementType value);

//弹栈
ElementType PopStack(SeqStack s);

//打印元素
void PrintStack(SeqStack s);

//获得长度
int StackLength(SeqStack s);

//清空栈
void StackClear(SeqStack s);
