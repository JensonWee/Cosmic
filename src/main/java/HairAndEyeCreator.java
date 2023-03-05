/*
    This file is part of the OdinMS Maple Story Server
    Copyright (C) 2008 ~ 2010 Patrick Huy <patrick.huy@frz.cc>
                       Matthias Butz <matze@odinms.de>
                       Jan Christian Meyer <vimes@odinms.de>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation. You may not use, modify
    or distribute this program under any other version of the
    GNU Affero General Public License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import provider.DataDirectoryEntry;
import provider.DataFileEntry;
import provider.DataProvider;
import provider.DataProviderFactory;
/*
 * Author: Xerdox
 */
public class HairAndEyeCreator {
    public static void main(String args[]) throws IOException {
        File hairFolder = new File("C:/Users/weejx/Desktop/Git Repos/Cosmic/wz/Character.wz/Hair");
        File[] hairfileList = hairFolder.listFiles();
        File faceFolder = new File("C:/Users/weejx/Desktop/Git Repos/Cosmic/wz/Character.wz/Face");
        File[] facefileList = faceFolder.listFiles();
        ArrayList<Integer> hairList = new ArrayList<Integer>();
        ArrayList<Integer> faceList = new ArrayList<Integer>();
        for(File i : hairfileList){
            if(i.isFile()){
                hairList.add(Integer.parseInt(i.getName().split(".img.xml")[0].replaceAll("\\s+","")));
            }
        }
        System.out.println("========================================================");
        for(File z : facefileList){
            if(z.isFile()){
                faceList.add(Integer.parseInt(z.getName().split(".img.xml")[0].replaceAll("\\s+","")));
            }
        }
        System.out.println(faceList);
        StringBuilder sb = new StringBuilder();
        FileOutputStream out = new FileOutputStream("hairAndFacesID.txt", true);
        System.out.println("Loading Male Hairs!");
        sb.append("hairMale:\r\n");
        for (Integer id : hairList) {
            if (((id >= 35390 && id  < 36990) || (id >= 39260 && id  < 39300) || (id >= 39370 && id  < 39400) || (id >= 39530 && id  < 39560)) && id % 10 == 0) {
                sb.append(id).append(", ");
            }
        }
        System.out.println("Loading Female Hairs!");
        sb.append("\r\n\r\n");
        sb.append("hairFemale:\r\n");
        for (Integer id : hairList) {
            if (((id >= 34860 && id  < 35390) || (id >= 36990 && id  < 39260) || (id >= 39300 && id  < 39370) || (id >= 39400 && id  < 39530) || (id >= 39560 && id  < 39887)) && id % 10 == 0) {
                sb.append(id).append(", ");
            }
        }
        System.out.println("Loading Male Faces!");
        sb.append("\r\n\r\n");
        sb.append("faceMale:\r\n");
        for (Integer id : faceList) {
            if ((id / 1000 == 20) && id % 1000 < 100) {
                sb.append(id).append(", ");
            }
        }
        System.out.println("Loading Female Faces!");
        sb.append("\r\n\r\n");
        sb.append("faceFemale:\r\n");
        for (Integer id : faceList) {
            if ((id / 1000 == 21) && id % 1000 < 100) {
                sb.append(id).append(", ");
            }
        }
        sb.append("\r\n\r\n");
        out.write(sb.toString().getBytes());
    }
}