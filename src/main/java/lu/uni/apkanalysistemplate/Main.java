package lu.uni.apkanalysistemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lu.uni.apkanalysistemplate.utils.CommandLineOptions;
import lu.uni.apkanalysistemplate.utils.Constants;
import soot.Body;
import soot.BodyTransformer;
import soot.G;
import soot.PackManager;
import soot.Scene;
import soot.SceneTransformer;
import soot.Transform;
import soot.options.Options;


/**
 * This class is a template for APK analysis
 * For educational purpose
 *
 * @author  Jordan Samhi
 * @version 1.0
 * @since   2021
 */

public class Main {
	public static void main(String[] args) throws Throwable {
		System.out.println(String.format("%s v1.0 started on %s\n", Constants.TOOL_NAME, new Date()));
		CommandLineOptions.v().parseArgs(args);

		/*
		 * Soot options initialization
		 */
		initializeSoot();

		/*
		 * The whole-jimple transformation pack.
		 * This is the primary pack into which you should insert any inter-procedural/whole-program analysis.
		 * When it executes, a call-graph has already been computed and can be accessed right away.
		 */
		PackManager.v().getPack("wjtp").add(
				new Transform("wjtp.myTransform", new SceneTransformer() {
					protected void internalTransform(String phaseName, @SuppressWarnings("rawtypes") Map options) {
						// YOUR CODE HERE
					}
				}));

		/*
		 * The jimple transformation pack.
		 * This is usually where you want to place your intra-procedural analyses.
		 */
		PackManager.v().getPack("jtp").add(
				new Transform("jtp.myTransform", new BodyTransformer() {
					protected void internalTransform(Body body, String phase, @SuppressWarnings("rawtypes") Map options) {
						// YOUR CODE HERE
					}
				}));
		PackManager.v().runPacks();
	}

	/**
	 * Initialize Soot options
	 * It mimics command-line options
	 */
	private static void initializeSoot() {
		G.reset();
		Options.v().set_allow_phantom_refs(true);
		Options.v().set_output_format(Options.output_format_none);
		Options.v().set_src_prec(Options.src_prec_apk);
		Options.v().set_whole_program(true);
		List<String> dirs = new ArrayList<String>();
		dirs.add(CommandLineOptions.v().getApk());
		Options.v().set_process_dir(dirs);
		Options.v().set_force_android_jar(CommandLineOptions.v().getPlatforms());
		Scene.v().loadNecessaryClasses();
	}
}