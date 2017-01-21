public class TringlerDeath
{
	double			pos;
	double[]	xPoints1;
	double[]	xPoints2;
	double[]	yPoints1;
	double[]	yPoints2;
	double		separationSpeed;
	double separationAngle;
/**
 * 
 * @param t former tringler
 * @param dcx death cause x
 * @param dcy death cause y
 */
	public TringlerDeath(Tringler t, double dcx, double dcy)
	{
		separationAngle=Math.atan2(dcy-t.y, dcx-t.x);
		xPoints1= new double [3];
		yPoints1= new double [3];
		xPoints2= new double [3];
		yPoints2= new double [3];
		//first corpse
	xPoints1[0] = (t.x + Tringler.radius * Math.cos(separationAngle));
	yPoints1[0] = (t.y + Tringler.radius * Math.sin(separationAngle));
	xPoints1[1] = (t.x - Tringler.radius * Math.cos(separationAngle)/2);
	yPoints1[1] = (t.y - Tringler.radius * Math.sin(separationAngle)/2);
	xPoints1[2] = (int) (t.x + Tringler.radius * Math.cos(t.rotation + Math.PI / 3 * 1));
	yPoints1[2] = (int) (t.y + Tringler.radius * Math.sin(t.rotation + Math.PI / 3 * 1));
	//second corpse
	xPoints1[0] = (t.x + Tringler.radius * Math.cos(separationAngle));
	yPoints1[0] = (t.y + Tringler.radius * Math.sin(separationAngle));
	xPoints1[1] = (t.x - Tringler.radius * Math.cos(separationAngle)/2);
	yPoints1[1] = (t.y - Tringler.radius * Math.sin(separationAngle)/2);
	xPoints1[2] = (int) (t.x + Tringler.radius * Math.cos(t.rotation + Math.PI / 3 * 1));
	yPoints1[2] = (int) (t.y + Tringler.radius * Math.sin(t.rotation + Math.PI / 3 * 1));
	pos=1;
	separationSpeed=30;
	separationAngle+=Math.PI/2;
	}
	
	public void update (double dt)
	{
		for (int i=0;i<3;i++)
		{
			xPoints1[i]+=separationSpeed*Math.cos(separationAngle)*dt;
			yPoints1[i]+=separationSpeed*Math.cos(separationAngle)*dt;
			xPoints2[i]-=separationSpeed*Math.cos(separationAngle)*dt;
			yPoints2[i]-=separationSpeed*Math.cos(separationAngle)*dt;
		}
		pos-=dt;
	}
}
