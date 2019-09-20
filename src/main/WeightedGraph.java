import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WeightedGraph {

  //Number of unique nodes
  private int length;
  //This will be the final graph we use to solve the problem
  private String[][] graph;
  //This is the list of nodes as they are inputted, need to be sorted
  private Node[] nodesOriginal;
  //This is the list of nodes once seperated by type
  private Node[] nodesUpdated;

  public WeightedGraph(Node[] nodesOriginal) {
    this.nodesOriginal = nodesOriginal;
    length = nodesOriginal.length;
    graph = new String[length][length + 1];
    buildGraph();
  }


  public void buildGraph() {

    nodesUpdated = seperateNodes();

    //Takes sorted list and creates the 2D array of the graph
    for (int i = 0; i < length; i ++) {

      //This adds the names of each value to the first index in each row
      graph[i][0] = nodesUpdated[i].getName();

      for (int j = 1; j < length + 1; j++) {
        //Adds a 1 for every edge, signifying that we are unsure if there is a valid connection
        graph[i][j] = "1";
      }
    }
    setDefaultZeros();
  }


  /*
  * This method is used to help build the graph before problem is solved. Uses the
  * list of unsorted nodes (nodesOriginal) and hashes them into 4 ArrayLists
  * seperated by type. The lists are then recombined into a new array ordered
  * by type. The order of the elements themselves is not relevant, it is only
  * imoprtant that they be seperated by type.
  */
  private Node[] seperateNodes() {
    //HashMap to store the types of each Node (first name, item, etc)
    //Used to seperate the items in graph by type
    //The ArrayList will store all of the values at each type
    HashMap<String, ArrayList<Node>> types = new HashMap<String, ArrayList<Node>>();

    for (Node n : nodesOriginal) {
      //HashMap of 4 empty arraylists, key of each hash is the type
      types.put(n.getType(), new ArrayList<Node>());
    }

    //Populating each ArrayList in the hashmap
    for (Node n : nodesOriginal) {
      types.get(n.getType()).add(n);
    }

    //Adding elements from HashMap ArrayLists to a new Array. Will now be in order
    //Return value
    Node[] arr = new Node[length];
    int i = 0;
    //Iterates through Map and adds elements to arr, seperated by type
    for (Map.Entry<String, ArrayList<Node>> entry : types.entrySet()) {
		    for (Node s : entry.getValue()) {
          arr[i] = s;
          i++;
        }
		}
    return arr;
  }


/*
* Sets the default zeros for the graph. The default zeros are for connections between the
* same type   i.e. all of the first names will have a connecrtion of 0 between themselves
*/
private void setDefaultZeros() {

  for (int i = 0; i < length; i ++) {
    for (int j = i; j < length; j ++) {
      if (nodesUpdated[i].getType().equals(nodesUpdated[j].getType())) {
        graph[i][j + 1] = "0";
        graph[j][i + 1] = "0";
      }
    }
  }
}

public void addConnection(Node n1, Node n2, boolean bool) {
  int idx1 = -1;
  int idx2 = -1;
  for (int i = 0; i < length; i ++) {
    if (nodesUpdated[i].getName().equals(n1.getName())) {
      idx1 = i;
    } else if (nodesUpdated[i].getName().equals(n2.getName())) {
      idx2 = i;
    }
  }
  if (bool) {
    graph[idx1][idx2 + 1] = "2";
    graph[idx2][idx1 + 1] = "2";
  } else {
    graph[idx1][idx2 + 1] = "0";
    graph[idx2][idx1 + 1] = "0";
  }
  setZeros();
}

private void setZeros() {
  //Number of elements per type
  int numPerType = length / 4; //3

  //Nested for loops iterate through the whole graph looking for any '2s'
  for (int i = 0; i < length; i++){
    for (int j = 1; j < length + 1; j ++) {
      if (graph[i][j].equals("2")) {

        //finds which type group the 2 was found in (e.g. first names would be group 1,
        //items would be group 2, etc.)
        int group = (j-1) / numPerType + 1;//4

        //Iterates through that group only, setting everything but the 2 to a zero
        for (int x = (group - 1) * numPerType + 1; x < (group) * numPerType + 1; x++) {
          if (!graph[i][x].equals("2"))
            graph[i][x] = "0";
        }
      }
    }
  }
}


  public void printGraph() {
    //prints graph
    for (int i = 0; i < length; i ++) {
      for (int j = 0; j < length + 1; j ++) {
        System.out.print(graph[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
