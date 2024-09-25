public class TestPlanet {
	public static void main(String[] args) {
		Planet[] p = new Planet[2];
		p[0] = new Planet(2,3,6,7,10,"p1.gif");
		p[1] = new Planet(5,7,9,11,20,"p2.gif");

		System.out.println(p[0].calcNetForceExertedByX(p));
		System.out.println(p[0].calcNetForceExertedByY(p));
		System.out.println(p[1].calcNetForceExertedByX(p));
		System.out.println(p[1].calcNetForceExertedByY(p));
	}
}
