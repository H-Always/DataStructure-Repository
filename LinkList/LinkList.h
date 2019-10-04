#pragma once
/**
 * @FlieName SequenceList
 * @Description: TODO ����ͷ�ļ�
 * @Author ��˪
 * @Date 2019/10/3
 * @Version V1.0
 **/

using ElementType = int;	//����Ԫ������

typedef struct Node
{
	ElementType Data;		//������
	Node* Next = NULL;		//ָ����
}*LinkList;


//������ĳ�ʼ��
bool InitList(Node* Head);

//�жϵ������Ƿ�Ϊ��
bool Empty(LinkList Head);

//ͷ�巨��������
void CreatFormHead(LinkList Head);

//β�巨����
void CreatFormTail(Node* Head);

//����±�Ԫ��
int GetIndex(LinkList Head, int i);

//��õ�һ��ֵ��Ӧ�±�
int GetLocation(LinkList Head, ElementType value);

//��ȡ����
int length(LinkList Head);

//����ڵ�
bool InsertNode(LinkList Head, int i, ElementType value);

// ɾ��ָ��Ԫ�ؽڵ�
bool DelValue(LinkList Head,ElementType value);

// ɾ��ָ���±�ڵ�
bool DelIndex(LinkList Head, int i);

//�������
void ClearList(LinkList Head);

//��ӡ����Ԫ��
void PrintList(LinkList Head);


