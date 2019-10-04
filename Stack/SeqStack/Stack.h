#pragma once
/**
 * @FlieName SequenceList
 * @Description: TODO ˳��ջ�ṹ
 * @Author ��˪
 * @Date 2019/10/4
 * @Version V1.0
 **/
#define MAXSIZE 1024
using ElementType = int;

typedef struct Stack
{
	ElementType stack[MAXSIZE];
	int top; 		//ָ����
}*SeqStack;


//��ʼ��
void InitStack(SeqStack s);

//�ж��Ƿ�Ϊ��
bool StackEmpty(SeqStack s);

//ѹջ
bool PushStack(SeqStack s, ElementType value);

//��ջ
ElementType PopStack(SeqStack s);

//��ӡԪ��
void PrintStack(SeqStack s);

//��ó���
int StackLength(SeqStack s);

//���ջ
void StackClear(SeqStack s);