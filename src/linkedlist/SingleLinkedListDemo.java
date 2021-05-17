package linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        //加入按照编号的顺讯
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);

        //显示
        singleLinkedList.list();
    }
}

//定义一个SingleLinkedList，用来管理单链表
class SingleLinkedList {
    //初始化一个头结点,头结点不用动，不存放任何数据
    private final HeroNode head = new HeroNode(0, "", "");

    //添加节点到单项列表

    /**
     * 思路，当不考虑编号顺序时
     * 找到当前链表最后节点
     * 讲最后这个节点的next指向新的节点
     *
     * @param heroNode 新节点
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (temp.next != null) {
            //如果没有找到最后
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    /**
     * 第二种方式添加英雄，根据排名讲英雄插入到指定位置
     * 如果有这个排名，则添加失败，并给出提示
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，所以我们通过使用辅助指针来添加找到
        //因为单链表，因为我们找的temp是位于添加位置的前一个结点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //表示添加的英雄是否存在

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到了，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next; //后移
        }
        //判断flag值
        if (flag) {
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    /**
     * 显示列表
     */
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            //判断是否到链表的最后
            //输出结点的信息
            System.out.println(temp);
            //讲next后移
            temp = temp.next;
        }
    }

}


//定义一个HeroNode,每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    //构造器
    public HeroNode(int hNo, String hName, String hNickName) {
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;
    }

    //为了显示方法，我们重新toString


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
