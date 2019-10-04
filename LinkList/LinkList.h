#pragma once
/**
 * @FlieName SequenceList
 * @Description: TODO 链表头文件
 * @Author 余霜
 * @Date 2019/10/3
 * @Version V1.0
 **/

using ElementType = int;	//定义元素类型

typedef struct Node
{
	ElementType Data;		//数据域
	Node* Next = NULL;		//指针域
}*LinkList;


//单链表的初始化
bool InitList(Node* Head);

//判断单链表是否为空
bool Empty(LinkList Head);

//头插法创建链表
void CreatFormHead(LinkList Head);

//尾插法创建
void CreatFormTail(Node* Head);

//获得下标元素
int GetIndex(LinkList Head, int i);

//获得第一个值对应下标
int GetLocation(LinkList Head, ElementType value);

//获取长度
int length(LinkList Head);

//插入节点
bool InsertNode(LinkList Head, int i, ElementType value);

// 删除指定元素节点
bool DelValue(LinkList Head,ElementType value);

// 删除指定下标节点
bool DelIndex(LinkList Head, int i);

//清空链表
void ClearList(LinkList Head);

//打印所有元素
void PrintList(LinkList Head);


