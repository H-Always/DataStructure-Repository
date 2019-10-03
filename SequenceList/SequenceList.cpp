#include <iostream>
#include "SequenceList.h"
/**
 * @FlieName SequenceList
 * @Description: TODO 顺序表方法实现
 * @Author 余霜
 * @Date 2019/10/3
 * @Version V1.0
 **/


//初始化,就是把一个顺序表置为空，如果不为空的话，直接把长度置为零就行
void InitList(SeqList *L)
{
	if (L == NULL)
	{
		return;
	}

	L->length = 0;
	return;
}


//获得当前顺序表长度
int ListLength(SeqList *L)
{
	if (L == NULL)
	{
		return 0;
	}

	return L->length;
}


//获得第i个元素的值
int GetData(PSeqList L, int i) 
{
	if (i > L->length || i < 1)
	{
		printf_s("Input is ileague");
		return 0;
	}

	return L->data[i - 1];
}


//插入元素 ,先判断是否合法
//合法条件是插入下标不能小于1，不能大于length+1，表满不能插入
//最后插入完元素记得length++
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


//删除操作，如果合法的话，从后向前覆盖
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


//元素查找，如果存在就返回该元素所在位置
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

//在表头插入元素
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

//删除表头元素
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


//尾插
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

//尾删
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

//清空整个表
bool ClearList(PSeqList L)
{
	L->length = 0;

	return true;
}

//判断表是否为空
bool EmptyList(PSeqList L)
{
	if (L->length == 0)
	{
		return true;
	}

	return false;
}

//打印元素
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