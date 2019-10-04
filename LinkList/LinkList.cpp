#include <iostream>
#include <cstdlib>
#include "LinkList.h"
/**
 * @FlieName SequenceList
 * @Description: TODO ������ʵ��
 * @Author ��˪
 * @Date 2019/10/3
 * @Version V1.0
 **/

using namespace std;

//��ʼ����Ҳ���Ƿ���һ���ڴ�Ȼ����Ϊ��
//�����������Ҫ��ʼ��
bool InitList(Node* Head)
{
	Head = (LinkList)malloc(sizeof(LinkList));

	if (Head == NULL)
	{
		cout << "Memory allocation fail" << endl;;
		return false;
	}

	Head->Next = NULL;

	return true;
}

//�ж��Ƿ�Ϊ������
bool Empty(LinkList Head)
{
	if (Head->Next == NULL)
	{
		return true;
	}

	return false;
}

//ͷ�崴������
void CreatFormHead(LinkList Head)
{
	
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

//β�巨����
void CreatFormTail(LinkList Head)
{
	LinkList p ;
	LinkList  temp = Head;
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


//��������±�Ԫ��
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


//��õ�һ������Ԫ�ض�Ӧ�±�
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


//������ĳ���
int length(LinkList Head)
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

//����λ�ò���
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
			Temp = (LinkList)malloc(sizeof(LinkList));  //�½�һ�����
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

// ɾ��ָ��Ԫ�ؽڵ�
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


// ɾ��ָ���±�ڵ�
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


//�������
void ClearList(LinkList Head)
{
	Head->Next = NULL;
}

//��ӡ����Ԫ��
void PrintList(LinkList Head)
{
	LinkList p = Head->Next;

	while (p)
	{
		cout << p->Data << endl;
		p = p->Next;
	}

	return;
}