package main;

import java.applet.Applet;
import java.awt.BorderLayout;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;

public class UglyCube extends Applet {
	private SimpleUniverse universe;

	public UglyCube() {
	}

	public void init() {
		// canvas to draw on, ask SimpleUniverse what config to use
		Canvas3D canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		setLayout(new BorderLayout());
		add("Center", canvas);
		// create top of our scene graph
		BranchGroup scene = new BranchGroup();
		// create universe, and attach our geometry to it.
		SimpleUniverse u = new SimpleUniverse(canvas);
		u.getViewingPlatform().setNominalViewingTransform();
		// Create the bounding leaf node
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
		// Create the transform node
		TransformGroup transformGroup = new TransformGroup();
		transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		// Create the drag behavior node
		MouseRotate behavior = new MouseRotate();
		behavior.setTransformGroup(transformGroup);
		transformGroup.addChild(behavior);
		behavior.setSchedulingBounds(bounds);
		// Create the zoom behavior node
		MouseZoom behavior2 = new MouseZoom();
		behavior2.setTransformGroup(transformGroup);
		transformGroup.addChild(behavior2);
		behavior2.setSchedulingBounds(bounds);
		// Create the zoom behavior node
		MouseTranslate behavior3 = new MouseTranslate();
		behavior3.setTransformGroup(transformGroup);
		transformGroup.addChild(behavior3);
		behavior3.setSchedulingBounds(bounds);
		transformGroup.addChild(new ColorCube(0.4));

		scene.addChild(transformGroup);
		u.addBranchGraph(scene);
	}

	// The following allows UglyCube to be run as an application
	// as well as an applet
	public static void main(String[] args) {
		new MainFrame(new UglyCube(), 256, 256);
	}
}
