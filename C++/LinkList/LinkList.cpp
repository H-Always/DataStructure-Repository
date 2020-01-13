#include <iostream>
#include <cstdlib>
#include "LinkList.h"
/**
 * @FlieName SequenceList
 * @Description: TODO 链表方法实现
 * @Author 余霜
 * @Date 2019/10/3
 * @Version V1.3
 **/

using namespace std;

//初始化，也就是分配一下内存然后置为空
//创建完链表就要初始化

bool InitList(LinkList Head)
{
	Head = (LinkList)malloc(sizeof(Node));

	if (Head == NULL)
	{
		cout << "Memory allocation fail" << endl;
		return false;
	}

	Head->Next = NULL;

	return true;
}
//判断是否为空链表
//为空返回T 不为空返回F
bool Empty(LinkList Head)
{
	if (Head->Next == NULL)
		return true;

	return false;
}


//头插创建链表，输入-1结束链表输入
void CreatFormHead(LinkList Head)
{
	cout << "This is creat form head" << endl;
	cout << "Input element data:" << endl;
	
	LinkList p;
	ElementType value;

	cin >> value;
	while (value != -1)
	{
		p = (LinkList)malloc(sizeof(Node));
		p->Data = value;
		p->Next = Head->Next;

		Head->Next = p;

		cin >> value;
	}
	
}


//尾插法创建,输入-1结束链表输入
void CreatFormTail(LinkList Head)
{
	cout << "This is creat form tail" << endl;
	cout << "Input element data:" << endl;

	LinkList p;
	LinkList temp = Head;

	int value;
	cin >> value;

	while (value!=-1)
	{
		p = (LinkList)malloc(sizeof(Node));
		p->Data = value;
		p->Next = temp->Next;

		temp->Next = p;
		temp = temp->Next;

		cin >> value;
	}
}


//获得输入下标元素
int GetIndex(LinkList Head, int k)
{
	if (Empty(Head))
	{
		cout << "This LinkList is empty" << endl;
		return -1;
	}

	if (k < 1)
	{
		cout << "input is illegal" << endl;
		return -1;
	}

	int i = 1;
	LinkList p = Head->Next;

	while (p)
	{
		if (i == k)
		{
			return p->Data;
		}
		p = p->Next;
		i++;
	}

	cout << "This index is nonentity" << endl;
	return -1;
}


//获得输入元素对应下标
int GetLocation(LinkList Head, ElementType value)
{
	if (Empty(Head))
	{
		cout << "This LinkList is empty" << endl;
		return -1;
	}

	int i = 1;
	LinkList p = Head->Next;

	while (p)
	{
		if (p->Data == value)
		{
			return i;
		}
		p = p->Next;
		i++;
	}

	cout << "This element is nonentity" << endl;
	return -1;
}


//求单链表的长度
int Length(LinkList Head)
{
	LinkList p;
	p = Head->Next;
	int len = 0;
	while (p)
	{
		len++;
		p = p->Next;
	}
	return len;
}


//任意位置插入
bool InsertNode(LinkList Head, int k, ElementType value)
{
	if (k < 1)
	{
		cout << "input is illegal" << endl;
		return false;
	}

	LinkList p = Head;
	LinkList Temp;

	int i = 1;
	while (p != NULL)
	{
		if (i == k)
		{
			Temp = (LinkList)malloc(sizeof(Node));  //新建一个结点
			Temp->Data = value;
			Temp->Next = p->Next;
			p->Next = Temp;
			return true;
		}
		p = p->Next;
		i++;
	}

	return false;

}


// 删除指定元素节点
bool DelValue(LinkList Head, ElementType value)
{
	if (Empty(Head))
	{
		cout << "This LinkList is empty" << endl;
		return false;
	}

	LinkList p = Head;

	while (p->Next)
	{
		if (p->Next->Data == value)
		{
			p->Next = p->Next->Next;
			continue;
		}
		p = p->Next;
	}

	return true;
}


// 删除指定下标节点
bool DelIndex(LinkList Head, int k)
{
	if (Empty(Head))
	{
		cout << "This LinkList is empty" << endl;
		return false;
	}

	if (k < 1)
	{
		cout << "input is illegal" << endl;
		return false;
	}

		
	LinkList p = Head;
	int i = 1;

	while (p)
	{
		if (i == k)
		{
			p->Next = p->Next->Next;
		}
		i++;
		p = p->Next;
	}

	cout << "input is illegal" << endl;
	return false;

}


//清空链表
void ClearList(LinkList Head)
{
	Head->Next = NULL;
	cout << "Clear list success" << endl;
}


//销毁链表

void DestoryList(LinkList Head) {
	LinkList p = Head->Next;
	LinkList q;

	while (p!= NULL) {
		q = p;
		p = p->Next;
		free(q);
		q = NULL;
	}

	Head->Next = NULL;

	cout << "Destory Success!" << endl;
}

//打印所有元素
void PrintList(LinkList Head)
{
	 
	if (Empty(Head))
	{
		cout << "LinkList is Empty" << endl;
		return;
	}

	LinkList p = Head->Next;

	cout << "LinlList Element:" << endl;
	while (p!=NULL)
	{
		cout << p->Data << " ";
		p = p->Next;
	}
	cout << endl;

	return;
}