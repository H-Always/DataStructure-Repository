#pragma once
/**
 * @FlieName SequenceList
 * @Description: TODO ˳���ṹ������ؽӿ�
 * @Author ��˪
 * @Date 2019/10/3
 * @Version V1.0
 **/

#define MaxSize 1024		//����
using ElementType = int;	// DataType �� int �ı��� 

typedef struct
{
	ElementType data[MaxSize];	//������洢���Ա��е�Ԫ��
	ElementType length;         //˳���ĳ���
}SeqList, *PSeqList;			//��������������ָ����������ݲ���ʱ�� SeqList *L ���� PSeqList L ����

//˳���ĳ�ʼ������
void InitList(SeqList *L);

//��˳���ĳ���
int ListLength(SeqList *L);

//�������ݱ��е�i��Ԫ�ص�ֵ
int GetData(PSeqList L, int i); 

//��˳���ĵ�i��λ�ò���Ԫ��
bool InsList(PSeqList L, int i, ElementType e);

//ɾ��˳���L�ĵ�i������Ԫ��
bool DelList(PSeqList L, ElementType i);

//��������Ԫ��e�ڱ��е�λ��
int Locate(PSeqList L, ElementType e);

//ͷ�壬�ڱ�ͷ����Ԫ��e
bool PushFront(PSeqList L, ElementType e);

//ͷɾ,ɾ�����еĵ�һ��Ԫ��
bool PopFront(PSeqList L);

//β�壬�ڱ�β����Ԫ��e
bool PushBack(PSeqList L, ElementType e);

//βɾ��ɾ����βԪ��
bool PopBack(PSeqList L);

//���˳���
bool ClearList(PSeqList L);

//�ж�˳����Ƿ�Ϊ��
bool EmptyList(PSeqList L);

//��ӡ����Ԫ��
void PrintList(PSeqList L);  
