/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package asset.pipeline.grails;

import org.springframework.core.io.Resource;
import java.util.Date;

public class AssetAttributes {
	private boolean gzipExists = false;
	private boolean exists = false;
	private Resource resource;
	private Resource gzipResource;
	private boolean isDirectory = false;
	private Long fileSize;
	private Long gzipFileSize;
	private Date lastModified;

	public AssetAttributes(boolean exists, Boolean gzipExists, Boolean isDirectory, Long fileSize, Long gzipFileSize, Date lastModified, Resource resource, Resource gzipResource) {
		this.gzipExists = gzipExists;
		this.exists = exists;
		this.fileSize = fileSize;
		this.isDirectory = isDirectory;
		this.gzipFileSize = gzipFileSize;
		this.resource = resource;
		this.lastModified = lastModified;
		this.gzipResource = gzipResource;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public Resource getResource() {
		return this.resource;
	}

	public Resource getGzipResource() {
		return this.gzipResource;
	}

	public boolean exists() {
		return this.exists;
	}

	public boolean isDirectory() {
		return this.isDirectory;
	}

	public boolean gzipExists() {
		return this.gzipExists;
	}

	public Long getFileSize() {
		return this.fileSize;
	}

	public Long getGzipFileSize() {
		return this.gzipFileSize;
	}
}