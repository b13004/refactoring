public class MonsterZoo {
	double distance=0.0;//����������
	int balls=10;//�����X�^�[��߂܂�����{�[���̐�
	int fruits=0;//�Ԃ���ƃ����X�^�[���߂܂��₷���Ȃ�t���[�c

	//���͍ő�9�܂Ŏ��Ă�D�����擾�����egg��true���������C
	//�ړ����邽�т�,eggDistance��1.0km�����Z�����D
	//3km�ړ�����ƃ����_���Ń����X�^�[���z��
	double eggDistance[] = new double[9];
	boolean egg[] = new boolean[9];

	//���[�U��Get���������X�^�[�ꗗ
	String userMonster[] = new String[100];

	//�����X�^�[�}�ӁD�����X�^�[�̖��O�ƃ��A�x(0.0~9.0)�����ꂼ��̔z��ɕۑ�����Ă���
	//���A�x�������ق����߂܂��ɂ���
	String monsterZukan[] = new String[22];
	double monsterRare[] = new double[22];

	//�Ăяo����1km distance��������
	void move(){
		this.distance++;
		for(int i=0;i<this.egg.length;i++){//���͈ړ��������i�ނƛz�����邽�߁C��km�ړ����������X�V����
			if(this.egg[i]==true){
				this.eggDistance[i]++;
			}
		}

		int flg1 = (int)(Math.random()*10);//0,1�̏ꍇ�̓Y�[station�C7~9�̏ꍇ�̓����X�^�[
		if(flg1<=1){
			System.out.println("�Y�[station���������I");
			int b=(int)(Math.random()*3);//ball,fruits,egg�������_���ɏo��
			int f=(int)(Math.random()*2);
			int e=(int)(Math.random()*2);
			System.out.println("�{�[����"+b+"�C"+"�t���[�c��"+f+"��"+"����"+e+"��Get�����I");
			this.balls=this.balls+b;
			this.fruits=this.fruits+f;
			if(e>=1){//����1�ȏ�Get������
				//egg[]��10�ȏ㗑���Ȃ��ꍇ�͐V�������f�[�^���Z�b�g����
				for(int i=0;i<this.eggDistance.length;i++){
					if(this.egg[i]==false){
						this.egg[i]=true;
						this.eggDistance[i]=0.0;
						break;
					}
				}
			}
		}else if(flg1>=7){
			int m = (int)(this.monsterZukan.length*Math.random());//monsterZukan���烉���_���Ƀ����X�^�[���o��
			System.out.println(this.monsterZukan[m]+"�����ꂽ�I");
			for(int i=0;i<3&&this.balls>0;i++){//�߂܂��� or 3��{�[���𓊂���܂ŌJ��Ԃ�
				int r = (int)(6*Math.random());//0~5�܂ł̐����������_���ɕԂ�
				if(this.fruits>0){
					System.out.println("�t���[�c�𓊂����I�߂܂��₷�����{�ɂȂ�I");
					this.fruits--;
					r = r * 2;
				}
				System.out.println(this.monsterZukan[m]+"�Ƀ{�[���𓊂���");
				this.balls--;
				if(this.monsterRare[m]<=r){//monsterRare[m]�̒l��r�ȉ��̏ꍇ
					System.out.println(this.monsterZukan[m]+"��߂܂����I");
					for(int j=0;j<userMonster.length;j++){
						if(this.userMonster[j]==null){
							this.userMonster[j]=this.monsterZukan[m];
							break;
						}
					}
					break;//�{�[�������I��
				}else{
					System.out.println(this.monsterZukan[m]+"�ɓ�����ꂽ�I");
				}
			}
		}
		for(int i=0;i<this.egg.length;i++){
			if(this.egg[i]==true&&this.eggDistance[i]>=3){
				System.out.println("�����z�����I");
				int m = (int)(this.monsterZukan.length*Math.random());
				System.out.println(this.monsterZukan[m]+"���Y�܂ꂽ�I");

				for(int j=0;j<userMonster.length;j++){
					if(this.userMonster[j]==null){
						this.userMonster[j]=this.monsterZukan[m];
						break;
					}
				}
				this.egg[i]=false;
				this.eggDistance[i]=0.0;
			}
		}
	}

	public double getDistance() {
		return distance;
	}

	public int getBalls() {
		return balls;
	}

	public int getFruits() {
		return fruits;
	}

	public String[] getUserMonster() {
		return userMonster;
	}

	public void setMonsterZukan(String[] monsterZukan) {
		this.monsterZukan = monsterZukan;
	}

	public void setMonsterRare(double[] monsterRare) {
		this.monsterRare = monsterRare;
	}
}