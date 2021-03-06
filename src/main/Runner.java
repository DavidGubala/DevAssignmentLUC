public class Runner {
  public static void main(String[] args) {
    Node a = new Node("pat", "firstname");
    Node b = new Node("lip", "item");
    Node c = new Node("paula", "firstname");
    Node d = new Node("jones", "lastname");
    Node e = new Node("doctor", "job");
    Node f = new Node("lawyer", "job");
    Node g = new Node("smith", "lastname");
    Node h = new Node("file", "item");

    Node i = new Node("teacher", "job");
    Node j = new Node("pam", "firstname");
    Node k = new Node("johnson", "lastname");
    Node l = new Node("compact", "item");

    Node m = new Node("pilot", "job");
    Node n = new Node("peggy", "firstname");
    Node o = new Node("dixon", "lastname");
    Node p = new Node("comb", "item");

    Node q = new Node("judge", "job");
    Node r = new Node("penny", "firstname");
    Node s = new Node("doe", "lastname");
    Node t = new Node("keyring", "item");

    Node[] list = new Node[20];
    list[0] = a;
    list[1] = b;
    list[2] = c;
    list[3] = d;
    list[4] = e;
    list[5] = f;
    list[6] = g;
    list[7] = h;
    list[8] = i;
    list[9] = j;
    list[10] = k;
    list[11] = l;
    list[12] = m;
    list[13] = n;
    list[14] = o;
    list[15] = p;
    list[16] = q;
    list[17] = r;
    list[18] = s;
    list[19] = t;
    WeightedGraph wg = new WeightedGraph(list);
    //wg.printGraph();

    wg.setCatNum(4);
    wg.setItemNum(5);

    //#1 Pilot last name johnson lost file
    wg.addConnection(m, k, true, true);
    wg.addConnection(h, m, true, true);
    wg.addConnection(h, k, true, true);

    //#2 teacher lost a comb
    wg.addConnection(i, p, true, true);

    //#3 dixon lost lipstick
    wg.addConnection(o, b, true, true); //dixon lipstick

    //#4 paula penny peggy not docs didn't lose ombs
    wg.addConnection(c, e, false, true);
    wg.addConnection(c, p, false, true);
    wg.addConnection(r, e, false, true);
    wg.addConnection(r, p, false, true);
    wg.addConnection(n, e, false, true);
    wg.addConnection(n, p, false, true);

    //#5 pam didn't lose file or keyring
    wg.addConnection(j, h, false, true);
    wg.addConnection(j, t, false, true);

    //#6 paula, not smith or doe, lost compact
    wg.addConnection(c, g, false, true);
    wg.addConnection(c, s, false, true);
    wg.addConnection(c, l, true, true);

    //#7 penny not lawyer or judge
    wg.addConnection(r, f, false, true);
    wg.addConnection(r, q, false, true); //judge  penny NOT

    //#8 peggy not teacher, jones, smith, or johnson
    wg.addConnection(n, i, false, true);
    wg.addConnection(n, d, false, true);
    wg.addConnection(n, g, false, true);
    wg.addConnection(n, k, false, true);

    //#9 jones not judge, doe not doc
    wg.addConnection(c, q, false, true); //judge  paula NOT
    wg.addConnection(s, e, false, true);

    //#10 peggy and pat didn't lose lipstick
    wg.addConnection(n, b, false, true);
    wg.addConnection(a, b, false, true);





    System.out.println(wg.checkForCompletion());
    wg.printGraph();
    System.out.println();
    wg.printIncompleteGraph();
/*
      Node a = new Node("Bobby", "firstname");
      Node b = new Node("Charlotte", "firstname");
      Node c = new Node("Chocolate", "flavor");
      Node d = new Node("Candles","topping");
      Node e = new Node("Vanilla", "flavor");
      Node f = new Node("Sprinkles", "topping");
      Node g = new Node("Strawberry", "flavor");
      Node h = new Node("Frosting", "topping");
      Node i = new Node("Melonie", "firstname");

        Node[] simpleList = new Node[9];
        simpleList[0]= a;
        simpleList[1]= b;
        simpleList[2]= c;
        simpleList[3]= d;
        simpleList[4]= e;
        simpleList[5]= f;
        simpleList[6]= g;
        simpleList[7]= h;
        simpleList[8]= i;

        WeightedGraph test = new WeightedGraph(simpleList);
        test.setCatNum(3);
        test.setItemNum(3);

        test.addConnection(a,c,false,true);
        test.addConnection(c,h,true,true);
        test.printGraph();
        test.printIncompleteGraph();*/
//test2
  }


}
