public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static double G = 6.67e-11;

	public Planet(double xP, double yP, double xV,
		      double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double r = Math.sqrt((dx*dx) + (dy*dy));
		return r;
	}

	public double calcForceExertedBy(Planet p) {
		double m1 = mass;
		double m2 = p.mass;
		double r = calcDistance(p);
		double Fp = G * m1 * m2 / (r*r);
		return Fp;
	}

	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - xxPos;
		double r = calcDistance(p);
		double Fnet = calcForceExertedBy(p);
		double Fnetx = Fnet * dx / r;
		return Fnetx;
	}

        public double calcForceExertedByY(Planet p) {
                double dy = p.yyPos - yyPos;
                double r = calcDistance(p);
                double Fnet = calcForceExertedBy(p);
                double Fnety = Fnet * dy / r;
                return Fnety;
        }

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double Fnetx = 0;
		for (int i=0; i<allPlanets.length; i+=1) {
			if (allPlanets[i].equals(this)) {
				continue;
			}
			Fnetx += calcForceExertedByX(allPlanets[i]);
		
		}
		return Fnetx;
	}
	
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double Fnety = 0;
		for (int i=0; i<allPlanets.length; i+=1) {
			if (allPlanets[i].equals(this)) {
				continue;
			}
			Fnety += calcForceExertedByY(allPlanets[i]);
		}
		return Fnety;
	}

	public void update(double dt, double fX, double fY) {
		double anetx = fX / this.mass;
		double anety = fY / this.mass;
		this.xxVel = this.xxVel + dt * anetx;
		this.yyVel = this.yyVel + dt * anety;
		this.xxPos = this.xxPos + dt * xxVel;
		this.yyPos = this.yyPos + dt * yyVel;
	}

	public void draw() {
		double xPos = this.xxPos;
		double yPos = this.yyPos;
		String filename = "images/" + this.imgFileName;
		StdDraw.picture(xPos, yPos, filename);
	}
}
