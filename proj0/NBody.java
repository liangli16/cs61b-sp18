/**@SuppressWarnings("deprecation")*/
public class NBody {

	public static double readRadius(String filename) {
		In in = new In(filename);

		int num_planets = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int num_planets = in.readInt();
		double Radius = in.readDouble();
		Planet[] p_array = new Planet[num_planets];

		for (int i=0; i<num_planets; i+=1) {
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String fname = in.readString();
			p_array[i] = new Planet(xPos, yPos, xVel, yVel, mass, fname);
		}
		return p_array;
	}
	
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = NBody.readPlanets(filename); /**read planets array*/
		double Radius = NBody.readRadius(filename); /**read universe radius*/
		In in = new In(filename);
		int num_planets = in.readInt();

		/**Draw the Universe (background)*/
		String imageToDraw = "images/starfield.jpg";
		StdDraw.setScale(-Radius, Radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);

		/**Draw all planets*/
		for (Planet p:planets) {
			p.Draw();
		}
		
		/**Creating an Animation*/
		StdDraw.enableDoubleBuffering();
		for (int time = 0; time<T; time+=dt) {
			double xForces[] = new double[num_planets];
			double yForces[] = new double[num_planets];
			for (int i=0; i<num_planets; i+=1) {
				double fx = planets[i].calcNetForceExertedByX(planets);
				double fy = planets[i].calcNetForceExertedByY(planets);
				xForces[i] = fx;
				yForces[i] = fy;
				planets[i].update(time,fx,fy);
			}
			StdDraw.picture(0, 0, imageToDraw);
			for (Planet p:planets) {
				p.Draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		/**Print out the universe*/
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  	planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  	planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
	}
}
