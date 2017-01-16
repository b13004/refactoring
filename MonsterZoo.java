public class MonsterZoo {
	Distance distance=new Distance();//歩いた距離
	DroppedItems items=new DroppedItems() ;
	
	//ユーザがGetしたモンスター一覧
	String userMonster[] = new String[100];

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	String monsterZukan[] = new String[22];
	double monsterRare[] = new double[22];

		//卵を1つ以上Getしたら
		//egg[]に10個以上卵がない場合は新しい卵データをセットする
		void eggchack(){
			for(int i=0;i<items.egg.eggDistance.length;i++){
				if(items.egg.egg[i]==false)
					items.egg.egg[i]=true;
					items.egg.eggDistance[i]=0.0;
					break;
			}	
		}
		
		int usefruits(int r){
			if(items.throwsitems.fruits>0){
				System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
					items.throwsitems.fruits--;
					r = r * 2;
			}
			return r;
		}
		void newmonstar(int m){
			for(int j=0;j<userMonster.length;j++){
				if(this.userMonster[j]==null){
					this.userMonster[j]=this.monsterZukan[m];
					break;
				}
			}
		}

	//呼び出すと1km distanceが増える
	void move(){
		distance.distance++;
		for(int i=0;i<items.egg.egg.length;i++){
		//卵は移動距離が進むと孵化するため，何km移動したかを更新する
			if(items.egg.egg[i]==true){
				items.egg.eggDistance[i]++;
			}
		}
	
		int flg1 = (int)(Math.random()*10);
		//0,1の場合はズーstation，7~9の場合はモンスター

		if(flg1<=1){
			System.out.println("ズーstationを見つけた！");
			int newball=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
			int newfruit=(int)(Math.random()*2);
			int newegg=(int)(Math.random()*2);
			System.out.println("ボールを"+newball+"個，"+"フルーツを"+newfruit+"個"+"卵を"+newegg+"個throwsitemsした！");
			items.throwsitems.balls=items.throwsitems.balls+newball;
			items.throwsitems.fruits=items.throwsitems.fruits+newfruit;
			if(newegg>=1)eggchack();
		}
 		if(flg1>=7){
			int monstarnumber = (int)(this.monsterZukan.length*Math.random());
			//monsterZukanからランダムにモンスターを出す
			System.out.println(this.monsterZukan[monstarnumber]+"が現れた！");
			
				for(int i=0;i<3&&items.throwsitems.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
					int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
					r=usefruits(r);
					System.out.println(this.monsterZukan[monstarnumber]+"にボールを投げた");
					items.throwsitems.balls--;
					if(this.monsterRare[monstarnumber]>r){
						System.out.println(this.monsterZukan[monstarnumber]+"に逃げられた！");
						continue;
					}//monsterRare[m]の値がr以下の場合
						System.out.println(this.monsterZukan[monstarnumber]+"を捕まえた！");
						newmonstar(monstarnumber);
						return;
										
				}
			}
			for(int i=0;i<items.egg.egg.length;i++){
				if(items.egg.egg[i]==true&&items.egg.eggDistance[i]>=3){
					System.out.println("卵が孵った！");
					int monstarnumber= (int)(this.monsterZukan.length*Math.random());
					System.out.println(this.monsterZukan[monstarnumber]+"が産まれた！");

					newmonstar(monstarnumber);

					items.egg.egg[i]=false;
					items.egg.eggDistance[i]=0.0;
				}
			}
		}
	


	public double getDistance() {
		return distance.distance;
	}

	public double getBalls(){
		return items.throwsitems.balls;
	}	

	public void showThrowableItems(){
		System.out.println("手持ちのボールは"+items.throwsitems.balls+"個，フルーツは"+items.throwsitems.fruits+"個"); 
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

class Distance{
	double distance=0.0;
}
class DroppedItems{
	ThrowsItems throwsitems= new ThrowsItems();
	Egg egg =new Egg();
}
class ThrowsItems{
	int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ
}
class Egg{
	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	double eggDistance[] = new double[9];
	boolean egg[] = new boolean[9];
}



