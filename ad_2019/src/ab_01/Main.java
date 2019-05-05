package ab_01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SET<String> arrayListSet = new ArrayListSet<String>();
		SET<String> containerSet = new ContainerSet<String>();
		SET<String> arraySet = new ArraySet<String>();
		testeContainerSet(10);
		testeContainerSet(100);
		testeContainerSet(1000);
		testeContainerSet(10000);
		testeContainerSet(100000);

		
	}
	
	public static void testeContainerSet(int k) {
		ContainerSet<Integer> containerSet = new ContainerSet<Integer>();
		KEY [] posArrayKey = new KEY [k];
		for (int i = 0; i < k; i++) {
			containerSet.add(i);
			posArrayKey[i] = containerSet.lastContainer.getPrev().getKey();
		}
		for (int i = k - 1; i >= 0; i--) {
			containerSet.delete(posArrayKey[i]);
		}
		System.out.println(containerSet.count);
		containerSet.count = 0;
		POS [] posArr = new POS [k];
		for (int i = 0; i < k; i++) {
			posArr[i] = containerSet.add(i);
		}
		for (int i = k - 1; i >= 0; i--) {
			containerSet.delete(posArr[i]);
		}
		System.err.println(containerSet.count);
	}

}
