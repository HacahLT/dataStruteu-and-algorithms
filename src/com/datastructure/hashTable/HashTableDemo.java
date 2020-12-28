package com.datastructure.hashTable;

import javax.naming.Name;

/**
 * @author Hacah
 * @date 2020/12/24 22:43
 * <p>
 * 有一个公司,当有新的员工来报道时,要求将该员工的信息加入(id,名字),当输入该员工的 id 时,
 * 要求查找到该员工的 所有信息.
 * <p>
 * 实现一个Hashtable存储员工数据。实现了员工的添加和搜索。
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(10);
        hashTab.add(new Emp(1, "nm"));
        hashTab.add(new Emp(2, "ki"));
        hashTab.add(new Emp(3, "mo"));
        hashTab.add(new Emp(6, "mod"));
        hashTab.add(new Emp(13, "mow"));
        hashTab.add(new Emp(3, "mo"));
        hashTab.printHashtable();

        // 查找对应的数据
        hashTab.findById(2);
    }

}

class HashTab {

    private EmpLinkList[] empLinkListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkListArray = new EmpLinkList[size];
        for (int i = 0; i < empLinkListArray.length; i++) {
            empLinkListArray[i] = new EmpLinkList();
        }
    }

    /**
     * 添加员工到哈希表
     *
     * @param emp
     */
    public void add(Emp emp) {
        int hash = hash(emp.getId());
        empLinkListArray[hash].add(emp);
    }


    /**
     * 在Hashtable查找数据
     *
     * @param id
     */
    public void findById(int id) {
        int hash = hash(id);
        empLinkListArray[hash].findById(id);
    }

    /**
     * 输出哈希表的数
     */
    public void printHashtable() {
        for (int i = 0; i < empLinkListArray.length; i++) {
            System.out.print("第" + (i + 1) + "个链表：");
            empLinkListArray[i].printList();
            System.out.println();
        }
    }

    /**
     * hash函数，把id进行hash得到数据
     *
     * @param id
     * @return
     */
    public int hash(int id) {
        return (id % size);
    }


}


class EmpLinkList {

    /** 设置一个头指针 */
    private Emp head;

    /**
     * 添加一个员工数据到链表中
     *
     * @param emp
     */
    public void add(Emp emp) {
        if (!empty()) {
            Emp tempNext = this.head;
            // 当链表的第一个节点id与添加的id相同，覆盖名字
            if (tempNext.getId() == emp.getId()) {
                tempNext.setName(emp.getName());
                return;
            }
            while (tempNext.next != null) {
                tempNext = tempNext.next;
                // 当链表的后面节点id与添加的id相同，覆盖名字
                if (tempNext.getId() == emp.getId()) {
                    tempNext.setName(emp.getName());
                    return;
                }
            }
            tempNext.next = emp;
        } else {
            head = emp;
        }
    }

    /**
     * 通过id查找链表中是都含有对应节点
     *
     * @param id
     */
    public void findById(int id) {
        if (!empty()) {
            Emp tempNext = this.head;
            if (tempNext.getId() == id) {
                System.out.println("存在对应id为" + id + "的数据");
                System.out.println("id: " + tempNext.getId() + ",name: " + tempNext.getName());
                return;
            }
            while (tempNext.next != null) {
                tempNext = tempNext.next;
                if (tempNext.getId() == id) {
                    System.out.println("存在对应id为" + id + "的数据");
                    System.out.println("id: " + tempNext.getId() + ",name: " + tempNext.getName());
                    return;
                }
            }
            System.out.println("没有该id的数据");
        }
    }


    /**
     * 打印链表的值
     */
    public void printList() {
        if (!empty()) {
            System.out.print("id=" + head.getId() + ",name=" + head.getName());
            Emp tempNext = this.head;
            while (tempNext.next != null) {
                System.out.print(" ==> id=" + tempNext.next.getId() + ",name=" + tempNext.next.getName());
                tempNext = tempNext.next;
            }
        }
    }

    /**
     * 检测是否为空链表
     *
     * @return
     */
    public boolean empty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }


}

/**
 * 声明员工类
 */
class Emp {
    private int id;
    private String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}