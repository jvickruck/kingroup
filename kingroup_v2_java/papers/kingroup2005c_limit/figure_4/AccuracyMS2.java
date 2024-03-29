package papers.kingroup2005c_limit.figure_4;
import kingroup.partition.bitsets.Partition;
import kingroup_v2.partition.ms2.MS2AlgModel;
import kingroup_v2.partition.ms2.MS2AlgV2;
import kingroup_v2.partition.simpson.DiploidSibship;
import kingroup_v2.partition.simpson.genotype_dist.GenotypeDistLocusAvr;
import kingroup_v2.pop.sample.sys.SysPop;
import tsvlib.project.ProjectLogger;

import javax.iox.LOG;

/**
 * Copyright KinGroup Team.
 * User: jc138691, Date: 29/11/2005, Time: 17:48:28
 */
public class AccuracyMS2  extends Figure4
{
  private static ProjectLogger log = ProjectLogger.getLogger(AccuracyMS2.class.getName());
  private final MS2AlgModel ALG_MODEL;
  public static void main(String[] args) {
    AccuracyMS2 test = new AccuracyMS2();
    LOG.setTrace(true);
    test.run_P50();
    System.exit(0);
  }
  public AccuracyMS2() {
    ALG_NAME = "MS2";

    ALG_MODEL = new MS2AlgModel();
    ALG_MODEL.setSibshipAlg(new DiploidSibship());
    ALG_MODEL.setGenotypeDistAlg(new GenotypeDistLocusAvr());

    N_TRIALS = 100; // 100-paper
  }
  public Partition partitionSysPop(SysPop sysPop)
  {
    MS2AlgV2 method = new MS2AlgV2(sysPop, ALG_MODEL);
    return method.partition();
  }
}
