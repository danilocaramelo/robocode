package deathCircleFinal;
import robocode.*;
import java.awt.Color;


public class DeathCircleV3 extends AdvancedRobot {

	String nomeInimigo;
	double distanciaInimigo;
	boolean inimigo = false;


	public void run() {

		setBodyColor(Color.black);
		setGunColor(Color.black);
		setRadarColor(Color.black);
		setScanColor(Color.black);
		setBulletColor(Color.black);

		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		setTurnRadarRight(360);

		while(true) {

			setTurnRadarRight(360);
			setTurnRight(5);
			setAhead(20);
			execute();

		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if (!inimigo || e.getDistance() < distanciaInimigo - 70 ||
				e.getName().equals(nomeInimigo)) {

			rastrearInimigo(e);

			if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10)
				setFire(Math.min(400 / distanciaInimigo, 3));

			double angulo = getHeading() - getGunHeading() + e.getBearing();
			setTurnGunRight(ajustarAngulo(angulo));
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {

	}

	public void onHitWall(HitWallEvent e) {

	}

	double ajustarAngulo(double angle) {
		while (angle >  180) angle -= 360;
		while (angle < -180) angle += 360;
		return angle;
	}

	public void onRobotDeath(RobotDeathEvent e) {
		if (e.getName().equals(nomeInimigo)) {
			reiniciarInimigo();
		}
	}

	public void rastrearInimigo(ScannedRobotEvent event) {
		nomeInimigo = event.getName();
		distanciaInimigo = event.getDistance();
		inimigo = true;
	}

	public void reiniciarInimigo() {
		nomeInimigo = "";
		distanciaInimigo = 0;
		inimigo = false;
	}
}
