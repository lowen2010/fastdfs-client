/**
* Copyright (C) 2008 Happy Fish / YuQing
*
* FastDFS Java Client may be copied only under the terms of the GNU Lesser
* General Public License (LGPL).
* Please visit the FastDFS Home Page http://www.csource.org/ for more detail.
**/

package org.csource.fastdfs.test;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class MyTest
{		
	public static String local_filename = "C:\\Users\\Administrator\\Desktop\\test.jpg";
	
  public static void main(String args[])
  {
  	
  	try
  	{
//  		ClientGlobal.init("E:\\lowen\\fastdfs-client-java-master\\src\\my_fdfs_client.conf");
  		ClientGlobal.init("/fdfs_client.properties");
  		System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
  		System.out.println("charset=" + ClientGlobal.g_charset);
 
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient client = new StorageClient(trackerServer, storageServer);
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("fileName", "test");
//  		meta_list[0] = new NameValuePair("author", "Mike");
  		String fileIds[] = client.upload_file(local_filename, "jpg", meta_list);
  		
  		System.out.println(fileIds.length); 
        System.out.println("组名：" + fileIds[0]); 
        System.out.println("路径: " + fileIds[1]);
  	}
  	catch(Exception ex)
  	{
  		ex.printStackTrace();
  	}
  }
}
