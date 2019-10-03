#include <iostream>
#include "SequenceList.h"
/**
 * @FlieName SequenceList
 * @Description: TODO ˳�����ʵ��
 * @Author ��˪
 * @Date 2019/10/3
 * @Version V1.0
 **/


//��ʼ��,���ǰ�һ��˳�����Ϊ�գ������Ϊ�յĻ���ֱ�Ӱѳ�����Ϊ�����
void InitList(SeqList *L)
{
	if (L == NULL)
	{
		return;
	}

	L->length = 0;
	return;
}


//��õ�ǰ˳�����
int ListLength(SeqList *L)
{
	if (L == NULL)
	{
		return 0;
	}

	return L->length;
}


//��õ�i��Ԫ�ص�ֵ
int GetData(PSeqList L, int i) 
{
	if (i > L->length || i < 1)
	{
		printf_s("Input is ileague");
		return 0;
	}

	return L->data[i - 1];
}


//����Ԫ�� ,���ж��Ƿ�Ϸ�
//�Ϸ������ǲ����±겻��С��1�����ܴ���length+1���������ܲ���
//��������Ԫ�ؼǵ�length++
bool InsertList(PSeqList L, int k, ElementType e)
{
	if (k > L->length + 1 || k < 1)
	{
		printf_s("Insert location is ileague");
		return false;
	}

	if (L->length == MaxSize)
	{
		printf_s("This sequenceList is full");
		return false;
	}

	for (int i = L->length; i >= k - 1; i++)
	{
		L->data[i] = L->data[i-1];
	}

	L->data[k - 1] = e;
	L->length++;

	return true;
}


//ɾ������������Ϸ��Ļ����Ӻ���ǰ����
bool DelList(PSeqList L, ElementType k)
{
	if (k<1||k>L->length)
	{
		printf_s("Delete location is ileague");
		return false;
	}

	for (int i = k; i < L->length; i++)
	{
		L->data[i - 1] = L->data[i];
	}

	L->length--;

	return true;
}


//Ԫ�ز��ң�������ھͷ��ظ�Ԫ������λ��
int Locate(PSeqList L, ElementType e)
{
	for (int i = 0; i < L->length; i++)
	{
		if (L->data[i]==e)
		{
			return i+1;
		}
	}

	printf_s("element inexistence in this sequence");

	return 0;
}

//�ڱ�ͷ����Ԫ��
bool PushFront(PSeqList L, ElementType e)
{
	if (L->length == MaxSize)
	{
		printf_s("This sequence is full");
	}

	for (size_t i = L->length; i < 0; i--)
	{
		L->data[i] = L->data[i - 1];
	}

	L->data[0] = e;
	L->length++;

	return true;
}

//ɾ����ͷԪ��
bool PopFront(PSeqList L)
{
	if (EmptyList(L))
	{
		printf_s("This sequence is empty");
		return false;
	}

	for (int i = 1; i < L->length; i++)
	{
		L->data[i-1] = L->data[i];
	}

	L->length--;

	return true;
}


//β��
bool PushBack(PSeqList L, ElementType e)
{
	if (L->length == MaxSize)
	{
		printf_s("This sequence is full");
		return false;
	}

	L->data[L->length] = e;
	L->length++;

	return true;
}

//βɾ
bool PopBack(PSeqList L)
{
	if (EmptyList(L))
	{
		printf_s("This sequence is empty");
		return false;
	}

	L->length--;

	return true;
}

//���������
bool ClearList(PSeqList L)
{
	L->length = 0;

	return true;
}

//�жϱ��Ƿ�Ϊ��
bool EmptyList(PSeqList L)
{
	if (L->length == 0)
	{
		return true;
	}

	return false;
}

//��ӡԪ��
void PrintList(PSeqList L)
{
	if (EmptyList(L))
	{
		printf_s("This sequence is empty");
		return;
	}

	for (int i = 0; i < L->length; i++)
	{
		printf("%-3d", L->data[i]);
	}
}