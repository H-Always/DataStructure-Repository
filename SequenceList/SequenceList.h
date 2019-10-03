#pragma once
/**
 * @FlieName SequenceList
 * @Description: TODO 顺序表结构及其相关接口
 * @Author 余霜
 * @Date 2019/10/3
 * @Version V1.0
 **/

#define MaxSize 1024		//最大表长
using ElementType = int;	// DataType 是 int 的别名 

typedef struct
{
	ElementType data[MaxSize];	//用数组存储线性表中的元素
	ElementType length;         //顺序表的长度
}SeqList, *PSeqList;			//创建表名变量和指针变量，传递参数时用 SeqList *L 或者 PSeqList L 都行

//顺序表的初始化操作
void InitList(SeqList *L);

//求顺序表的长度
int ListLength(SeqList *L);

//返回数据表中第i个元素的值
int GetData(PSeqList L, int i); 

//在顺序表的第i个位置插入元素
bool InsList(PSeqList L, int i, ElementType e);

//删除顺序表L的第i个数据元素
bool DelList(PSeqList L, ElementType i);

//查找数据元素e在表中的位置
int Locate(PSeqList L, ElementType e);

//头插，在表头插入元素e
bool PushFront(PSeqList L, ElementType e);

//头删,删除表中的第一个元素
bool PopFront(PSeqList L);

//尾插，在表尾插入元素e
bool PushBack(PSeqList L, ElementType e);

//尾删，删除表尾元素
bool PopBack(PSeqList L);

//清空顺序表
bool ClearList(PSeqList L);

//判断顺序表是否为空
bool EmptyList(PSeqList L);

//打印表中元素
void PrintList(PSeqList L);  
