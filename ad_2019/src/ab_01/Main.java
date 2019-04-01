package ab_01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SET<String> arrayListSet = new ArrayListSet<String>();
		SET<String> containerSet = new ContainerSet<String>();
		SET<String> arraySet = new arraySet<String>(String.class);
		
		POS pos = new POS();

		arrayListSet.add("1.Element");
		arrayListSet.add("2.Element");
		arrayListSet.add("3.Element");
		arrayListSet.add("4.Element");
		arrayListSet.add("5.Element");
		arrayListSet.add("6.Element");
		arrayListSet.add("7.Element");
		arrayListSet.showAll();
		pos.setInteger(4);
		arrayListSet.delete(pos);
		arrayListSet.showAll();
		arrayListSet.add("8.Element");
		arrayListSet.add("7.Element");
		arrayListSet.showAll();
		
		System.out.println();

		containerSet.add("1.Element");
		containerSet.add("2.Element");
		containerSet.add("3.Element");
		containerSet.add("4.Element");
		containerSet.add("5.Element");
		containerSet.add("6.Element");
		containerSet.add("7.Element");
		containerSet.showAll();
		pos.setInteger(4);
		containerSet.delete(pos);
		containerSet.showAll();
		containerSet.add("8.Element");
		containerSet.add("7.Element");
		containerSet.showAll();
		
		System.out.println();

		arraySet.add("1.Element");
		arraySet.add("2.Element");
		arraySet.add("3.Element");
		arraySet.add("4.Element");
		arraySet.add("5.Element");
		arraySet.add("6.Element");
		arraySet.add("7.Element");
		arraySet.showAll();
		pos.setInteger(4);
		arraySet.delete(pos);
		arraySet.showAll();
		arraySet.add("8.Element");
		arraySet.add("7.Element");
		arraySet.showAll();

		
	}

}
