package solar;

public class Planet {
	protected Coordinate coordinate;
	protected Coordinate orbitCenterCoordinate;
	protected int orbitRadius;

	public Planet() {
		this(1);
	}

	public Planet(int orbitRadius) {
		if (orbitRadius < 1)
			orbitRadius = 1;
		this.coordinate = new Coordinate(orbitRadius, 0);
		this.orbitCenterCoordinate = new Coordinate(0, 0);
		this.orbitRadius = orbitRadius;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Coordinate getOrbitCenterCoordinate() {
		return orbitCenterCoordinate;
	}

	public int getOrbitRadius() {
		return orbitRadius;
	}

	public boolean orbit() {
		if (coordinate.getX() == 0 && coordinate.getY() > 0) {
			coordinate.setX(orbitRadius);
			coordinate.setY(0);
		} else if (coordinate.getY() == 0 && coordinate.getX() < 0) {
			coordinate.setX(0);
			coordinate.setY(orbitRadius);
		} else if (coordinate.getX() == 0 && coordinate.getY() < 0) {
			coordinate.setX(-orbitRadius);
			coordinate.setY(0);
		} else {
			coordinate.setX(0);
			coordinate.setY(-orbitRadius);
		}
		return true;
	}

}
